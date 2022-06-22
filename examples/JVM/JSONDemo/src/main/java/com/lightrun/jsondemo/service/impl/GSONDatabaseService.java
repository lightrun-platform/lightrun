package com.lightrun.jsondemo.service.impl;

import com.google.gson.Gson;
import com.lightrun.jsondemo.model.DBObject;
import com.lightrun.jsondemo.model.History;
import com.lightrun.jsondemo.model.User;
import com.lightrun.jsondemo.service.AuthService;
import com.lightrun.jsondemo.service.JSONDatabaseService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GSONDatabaseService extends JSONDatabaseService {
    private final Gson gson = new Gson();

    public GSONDatabaseService(PasswordEncoder passwordEncoder, AuthService authService) {
        super(passwordEncoder, authService);
    }

    @Override
    protected User createUser(String json) {
        return gson.fromJson(json, User.class);
    }

    @Override
    protected DBObject createDBObject(String json) {
        return gson.fromJson(json, DBObject.class);
    }

    @Override
    protected String toJson(User user) {
        return gson.toJson(user);
    }

    @Override
    protected String toJson(DBObject dbObject) {
        return gson.toJson(dbObject);
    }

    @Override
    protected String toJson(History history) {
        return gson.toJson(history);
    }
}
