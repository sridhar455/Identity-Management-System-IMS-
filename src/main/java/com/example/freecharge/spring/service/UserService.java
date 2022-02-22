package com.example.freecharge.spring.service;

import com.example.freecharge.spring.dto.UserDto;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface UserService {



    UserDto signInViaCreds(UserDto requestModel, HttpServletResponse response);

    ResponseModel signOut(HttpServletRequest request, HttpServletResponse response);

    ResponseModel signinViaToken(HttpServletRequest requestModel, HttpServletResponse response);

    UserDto register(UserDto userDto);
}