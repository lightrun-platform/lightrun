package com.lightrun.jsondemo.ws;

import com.lightrun.jsondemo.model.DBObject;
import com.lightrun.jsondemo.model.User;
import com.lightrun.jsondemo.service.JSONDatabaseService;
import com.lightrun.jsondemo.service.impl.GSONDatabaseService;
import com.lightrun.jsondemo.service.impl.JacksonDatabaseService;
import com.lightrun.jsondemo.service.impl.MoshiDatabaseService;
import java.io.IOException;
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
    private final GSONDatabaseService gsonDatabaseService;
    private final JacksonDatabaseService jacksonDatabaseService;
    private final MoshiDatabaseService moshiDatabaseService;

    private JSONDatabaseService getService(String type) {
        if(type != null) {
            switch (type) {
                case "gson":
                    return gsonDatabaseService;
                case "jackson":
                    return jacksonDatabaseService;
            }
        }
        return moshiDatabaseService;
    }

    @PostMapping("/auth")
    public String auth(@RequestHeader(value = "type", required = false) String type,
                       @RequestBody User user) throws IOException {
        return getService(type).auth(user);
    }

    @PutMapping("/addUser")
    public void addUser(@RequestHeader(value = "type", required = false) String type,
                        @RequestBody User user) throws IOException {
        getService(type).addUser(user);
    }

    @PostMapping("/create")
    public String create(@RequestHeader(value = "type", required = false) String type,
                         @RequestHeader("authorization") String token, @RequestBody DBObject dbObject) throws IOException {
        return getService(type).create(token, dbObject);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestHeader(value = "type", required = false) String type,
                          @RequestHeader("authorization") String token, String id) throws IOException {
        return getService(type).delete(token, id);
    }

    @PostMapping("/update")
    public void update(@RequestHeader(value = "type", required = false) String type,
                       @RequestHeader("authorization") String token, @RequestBody DBObject dbObject) throws IOException {
        getService(type).update(token, dbObject);
    }

    @GetMapping("/read")
    public DBObject read(@RequestHeader(value = "type", required = false) String type,
                         @RequestHeader("authorization") String token, String id) throws IOException {
        return getService(type).read(token, id);
    }
}
