package com.example.freecharge.spring.dto;

//package com.example.freecharge.spring.entity;

import com.example.freecharge.spring.enumOBJ.Status;

public class UserDto
{
    private String username;
    private String password;
    private String email;
    private Status status;

    public UserDto() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }





}