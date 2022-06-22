package com.lightrun.jsondemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lightrun.jsondemo.model.DBObject;
import com.lightrun.jsondemo.model.History;
import com.lightrun.jsondemo.model.User;
import com.lightrun.jsondemo.service.AuthService;
import com.lightrun.jsondemo.service.JSONDatabaseService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JacksonDatabaseService extends JSONDatabaseService {
    private ObjectMapper mapper = new ObjectMapper();
    public JacksonDatabaseService(PasswordEncoder passwordEncoder, AuthService authService) {
        super(passwordEncoder, authService);

        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    protected User createUser(String json) throws JsonProcessingException {
        return mapper.readValue(json, User.class);
    }

    @Override
    protected DBObject createDBObject(String json) throws JsonProcessingException {
        return mapper.readValue(json, DBObject.class);
    }

    @Override
    protected String toJson(User user) throws JsonProcessingException {
        return mapper.writeValueAsString(user);
    }

    @Override
    protected String toJson(DBObject dbObject) throws JsonProcessingException {
        return mapper.writeValueAsString(dbObject);
    }

    @Override
    protected String toJson(History history) throws JsonProcessingException {
        return mapper.writeValueAsString(history);
    }
}
