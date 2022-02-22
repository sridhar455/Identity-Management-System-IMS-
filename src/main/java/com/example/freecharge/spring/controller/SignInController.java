package com.example.freecharge.spring.controller;

import java.util.UUID;

import com.example.freecharge.spring.helper.Helper;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import com.example.freecharge.spring.model.UserRC;
import com.example.freecharge.spring.repository.UserRepositoryRCImpl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/ims")
public class SignInController
{
    @Autowired
    private Helper helper;

    @PostMapping(value = "/signin/creds")
    public ResponseModel signinViaCred(@RequestBody RequestModel requestModel, HttpServletResponse response)
    {

        return helper.signInViaCreds(requestModel,response);

    }


    @PostMapping(value="/signin/token")
    public  ResponseModel signinViaToken(HttpServletRequest request, HttpServletResponse response)
    {
        return helper.signinViaToken(request ,response);
    }

}



//1.validate model
//2.check username exist or not
//3.Check Password is correct or not
//4.Create Session-generate token,save in redis
//5.Return succes and sesssion token