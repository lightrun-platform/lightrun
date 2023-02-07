package com.lightrun.jsondemo.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private String givenName;
    private String surname;
    private String email;
    private String hashedPassword;
    private String token;
    private String password;
}
