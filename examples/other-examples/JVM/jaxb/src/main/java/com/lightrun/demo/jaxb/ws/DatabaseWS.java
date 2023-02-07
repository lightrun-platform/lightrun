package com.lightrun.demo.jaxb.ws;

import com.lightrun.demo.jaxb.model.DBObject;
import com.lightrun.demo.jaxb.model.User;
import com.lightrun.demo.jaxb.service.XMLDatabaseService;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DatabaseWS {
    private final XMLDatabaseService xmlDatabaseService;

    @PostMapping("/auth")
    public String auth(@RequestHeader(value = "type", required = false) String type,
                       @RequestBody User user) throws IOException, JAXBException {
        return xmlDatabaseService.auth(user);
    }

    @PutMapping("/addUser")
    public void addUser(@RequestHeader(value = "type", required = false) String type,
                        @RequestBody User user) throws IOException, JAXBException {
        xmlDatabaseService.addUser(user);
    }

    @PostMapping("/create")
    public String create(@RequestHeader(value = "type", required = false) String type,
                         @RequestHeader("authorization") String token, @RequestBody DBObject dbObject) throws IOException, JAXBException {
        return xmlDatabaseService.create(token, dbObject);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestHeader(value = "type", required = false) String type,
                          @RequestHeader("authorization") String token, String id) throws IOException, JAXBException {
        return xmlDatabaseService.delete(token, id);
    }

    @PostMapping("/update")
    public void update(@RequestHeader(value = "type", required = false) String type,
                       @RequestHeader("authorization") String token, @RequestBody DBObject dbObject) throws IOException, JAXBException {
        xmlDatabaseService.update(token, dbObject);
    }

    @GetMapping("/read")
    public DBObject read(@RequestHeader(value = "type", required = false) String type,
                         @RequestHeader("authorization") String token, String id) throws IOException, JAXBException {
        return xmlDatabaseService.read(token, id);
    }
}
