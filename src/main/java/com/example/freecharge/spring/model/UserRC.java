package com.example.freecharge.spring.model;

import java.io.Serializable;

public class UserRC implements Serializable {
    String username;
    String password;
    String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRC(String username,String password,String token)
    {
        this.username=username;
        this.password=password;
        this.token=token;
    }
}
