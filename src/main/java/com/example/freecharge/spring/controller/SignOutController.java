package com.example.freecharge.spring.controller;

import com.example.freecharge.spring.helper.Helper;
import com.example.freecharge.spring.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/ims")
public class SignOutController
{


    @Autowired
    private Helper helper;

    @PostMapping(value="/signout")
    public ResponseModel signOut(HttpServletRequest request, HttpServletResponse response)
    {
        return helper.signOut(request,response);
    }
}

