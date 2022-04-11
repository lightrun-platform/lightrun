package com.lightrun.demo.jaxb.model;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "user")
public class User {
    private String login;
    private String givenName;
    private String surname;
    private String email;
    private String hashedPassword;
    private String token;
    private String password;
}
