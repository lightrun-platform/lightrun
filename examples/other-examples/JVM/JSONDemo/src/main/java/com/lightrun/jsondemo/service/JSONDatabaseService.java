package com.lightrun.jsondemo.service;

import com.google.gson.Gson;
import com.lightrun.jsondemo.model.Action;
import com.lightrun.jsondemo.model.DBObject;
import com.lightrun.jsondemo.model.History;
import com.lightrun.jsondemo.model.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class JSONDatabaseService {
    @Value("${db.location:~/myDB}")
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

    public String auth(User userObj) throws IOException {
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

    protected abstract User createUser(String json) throws IOException;
    protected abstract DBObject createDBObject(String json) throws IOException;
    protected abstract String toJson(User user) throws IOException;
    protected abstract String toJson(DBObject dbObject) throws IOException;
    protected abstract String toJson(History history) throws IOException;

    public void addUser(User user) throws IOException {
        File file = new File(getDbLocation() + user.getLogin() + ".user");
        if(file.exists()) {
            throw new RuntimeException("User already exists");
        }
        user.setHashedPassword(passwordEncoder.encode(user.getPassword()));
        user.setToken(UUID.randomUUID().toString());
        user.setPassword(null);
        String data = toJson(user);
        Files.writeString(file.toPath(), data, StandardOpenOption.CREATE_NEW);
    }

    private String validateToken(String token) throws IOException {
        String login = authService.getLogin(token);
        if(login == null) {
            throw new IOException("Invalid token");
        }
        return login;
    }

    public String create(String token, DBObject dbObject) throws IOException {
        String uuid = UUID.randomUUID().toString();
        dbObject.setId(uuid);

        File file = new File(getDbLocation() + uuid + ".data");
        String data = toJson(dbObject);
        addHistory(History.builder()
                .action(Action.CREATED)
                .objectId(uuid)
                .time(Instant.now())
                .ordinal(0)
                .userId(validateToken(token))
                .build());
        Files.writeString(file.toPath(), data, StandardOpenOption.CREATE_NEW);
        return uuid;
    }

    private void addHistory(History history) throws IOException {
        File historyFile = new File(getDbLocation() + history.getObjectId() + "." + history.getOrdinal());
        String historyData = toJson(history);
        Files.writeString(historyFile.toPath(), historyData, StandardOpenOption.CREATE_NEW);
    }

    private int getHistoryOrdinal(String id) {
        File parent = new File(getDbLocation());
        return Objects.requireNonNull(parent.list((dir, name) -> name.startsWith(id))).length - 1;
    }

    public boolean delete(String token, String id) throws IOException {
        File file = new File(getDbLocation() + id + ".data");
        addHistory(History.builder()
                .action(Action.DELETED)
                .objectId(id)
                .time(Instant.now())
                .ordinal(getHistoryOrdinal(id))
                .userId(validateToken(token))
                .build());
        return file.delete();
    }

    public void update(String token, DBObject dbObject) throws IOException {
        File file = new File(getDbLocation() + dbObject.getId() + ".data");
        addHistory(History.builder()
                .action(Action.UPDATED)
                .objectId(dbObject.getId())
                .time(Instant.now())
                .ordinal(getHistoryOrdinal(dbObject.getId()))
                .userId(validateToken(token))
                .build());
        String data = toJson(dbObject);
        Files.writeString(file.toPath(), data, StandardOpenOption.WRITE);
    }

    public DBObject read(String token, String id) throws IOException {
        File file = new File(getDbLocation() + id + ".data");
        if(!file.exists()) {
            return null;
        }
        return createDBObject(Files.readString(file.toPath()));
    }
}
