package com.lightrun.jsondemo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class AuthService {
    private Map<String, String> tokenLoginMap = new HashMap<>();
    private static Object LOCK = new Object();

    public void store(String token, String login) {
        synchronized (LOCK) {
            tokenLoginMap.put(token, login);
        }
    }

    public String getLogin(String token) {
        synchronized (LOCK) {
            return tokenLoginMap.get(token);
        }
    }
}
