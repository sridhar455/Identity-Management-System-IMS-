package com.example.freecharge.spring.controller;

import com.example.freecharge.spring.entity.UserDAO;
import com.example.freecharge.spring.helper.Helper;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import com.example.freecharge.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ims")
public class SignUpController
{

    @Autowired
    private Helper helper;


    @PostMapping(value="/register")
    public ResponseModel register(@RequestBody RequestModel signUpRequest)
    {
        return helper.register(signUpRequest);
    }
}
//1.Duplicate Username
//2.Validate Request
//3.Status Report
//rename requestmodel to signuprequest