package com.lightrun.demo.jaxb.service;

import com.lightrun.demo.jaxb.model.Action;
import com.lightrun.demo.jaxb.model.DBObject;
import com.lightrun.demo.jaxb.model.History;
import com.lightrun.demo.jaxb.model.User;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class XMLDatabaseService {
    @Value("${db.location:~/xmlDB}")
    private String dbLocation;

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    private String getDbLocation() {
        return dbLocation.replace("~", System.getProperty("user.home")) + "/";
    }

    @PostConstruct
    public void init() {
        new File(getDbLocation()).mkdirs();
    }

    public String auth(User userObj) throws IOException, JAXBException {
        File file = new File(getDbLocation() + userObj.getLogin() + ".user");
        if(!file.exists()) {
            throw new IOException("User not found");
        }
        User user = createUser(Files.readString(file.toPath()));

        if(passwordEncoder.matches(userObj.getPassword(), user.getHashedPassword())) {
            authService.store(user.getToken(), user.getLogin());
            return user.getToken();
        }
        throw new IOException("Login failed");
    }

    protected User createUser(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(User.class);
        return (User) context.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    protected DBObject createDBObject(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DBObject.class);
        return (DBObject) context.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    private String marshal(Object obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller mar = context.createMarshaller();
        try(StringWriter writer = new StringWriter()) {
            mar.marshal(obj, writer);
            return writer.toString();
        } catch (IOException e) {
            throw new JAXBException(e);
        }
    }

    protected String toXML(User user) throws JAXBException {
        return marshal(user);
    }

    protected String toXML(DBObject dbObject) throws JAXBException {
        return marshal(dbObject);
    }

    protected String toXML(History history) throws JAXBException {
        return marshal(history);
    }

    public void addUser(User user) throws JAXBException, IOException {
        File file = new File(getDbLocation() + user.getLogin() + ".user");
        if(file.exists()) {
            throw new RuntimeException("User already exists");
        }
        user.setHashedPassword(passwordEncoder.encode(user.getPassword()));
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(null);
        String data = toXML(user);
        Files.writeString(file.toPath(), data, StandardOpenOption.CREATE_NEW);
    }

    private String validateToken(String token) throws JAXBException, IOException {
        String login = authService.getLogin(token);
        if(login == null) {
            throw new IOException("Invalid token");
        }
        return login;
    }

    public String create(String token, DBObject dbObject) throws JAXBException, IOException {
        String uuid = UUID.randomUUID().toString();
        dbObject.setId(uuid);

        File file = new File(getDbLocation() + uuid + ".data");
        String data = toXML(dbObject);
        addHistory(new History(uuid, 0, Instant.now(), Action.CREATED, validateToken(token)));
        Files.writeString(file.toPath(), data, StandardOpenOption.CREATE_NEW);
        return uuid;
    }

    private void addHistory(History history) throws JAXBException, IOException {
        File historyFile = new File(getDbLocation() + history.getObjectId() + "." + history.getOrdinal());
        String historyData = toXML(history);
        Files.writeString(historyFile.toPath(), historyData, StandardOpenOption.CREATE_NEW);
    }

    private int getHistoryOrdinal(String id) {
        File parent = new File(getDbLocation());
        return Objects.requireNonNull(parent.list((dir, name) -> name.startsWith(id))).length - 1;
    }

    public boolean delete(String token, String id) throws JAXBException, IOException {
        File file = new File(getDbLocation() + id + ".data");
        addHistory(new History(id, getHistoryOrdinal(id), Instant.now(), Action.DELETED, validateToken(token)));
        return file.delete();
    }

    public void update(String token, DBObject dbObject) throws JAXBException, IOException {
        File file = new File(getDbLocation() + dbObject.getId() + ".data");
        addHistory(new History(dbObject.getId(), getHistoryOrdinal(dbObject.getId()), Instant.now(), Action.UPDATED, validateToken(token)));
        String data = toXML(dbObject);
        Files.writeString(file.toPath(), data, StandardOpenOption.WRITE);
    }

    public DBObject read(String token, String id) throws JAXBException, IOException {
        File file = new File(getDbLocation() + id + ".data");
        if(!file.exists()) {
            return null;
        }
        return createDBObject(Files.readString(file.toPath()));
    }
}
