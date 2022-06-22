package com.lightrun.jsondemo.service.impl;

import com.lightrun.jsondemo.model.DBObject;
import com.lightrun.jsondemo.model.History;
import com.lightrun.jsondemo.model.User;
import com.lightrun.jsondemo.service.AuthService;
import com.lightrun.jsondemo.service.JSONDatabaseService;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import java.io.IOException;
import java.time.Instant;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MoshiDatabaseService extends JSONDatabaseService {
    class InstantAdapter {
        @ToJson
        String toJson(Instant instant) {
            return instant.toEpochMilli() + "";
        }

        @FromJson Instant fromJson(String string) {
            return Instant.ofEpochMilli(Long.parseLong(string));
        }
    }

    private final Moshi moshi = new Moshi
            .Builder()
            .add(new InstantAdapter()).build();

    public MoshiDatabaseService(PasswordEncoder passwordEncoder, AuthService authService) {
        super(passwordEncoder, authService);
    }

    @Override
    protected User createUser(String json) throws IOException {
        return moshi.adapter(User.class).fromJson(json);
    }

    @Override
    protected DBObject createDBObject(String json) throws IOException {
        return moshi.adapter(DBObject.class).fromJson(json);
    }

    @Override
    protected String toJson(User user) {
        return moshi.adapter(User.class).toJson(user);
    }

    @Override
    protected String toJson(DBObject dbObject) {
        return moshi.adapter(DBObject.class).toJson(dbObject);
    }

    @Override
    protected String toJson(History history) {
        return moshi.adapter(History.class).toJson(history);
    }
}
