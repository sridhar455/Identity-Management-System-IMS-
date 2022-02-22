package com.example.freecharge.spring.service;

import java.util.*;

import com.example.freecharge.spring.dto.UserDto;
import com.example.freecharge.spring.entity.UserDAO;
import com.example.freecharge.spring.enumOBJ.Status;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import com.example.freecharge.spring.model.UserRC;
import com.example.freecharge.spring.repository.UserRepository;
import com.example.freecharge.spring.repository.UserRepositoryRCImpl;
import org.hibernate.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryRCImpl userRepositoryRC;

    @Override
    public UserDto register(UserDto userDto) {
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(userDto.getUsername());
        userDAO.setEmail(userDto.getEmail());
        userDAO.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDAO);
        userDto.setStatus(Status.REGESTERSUCCESS);
        return userDto;
    }

    @Override
    public UserDto signInViaCreds(UserDto userDto, HttpServletResponse response)
    {
        UserDAO userDAO = userRepository.findByusername(userDto.getUsername());
        if (userDAO == null)
        {
            userDto.setStatus(Status.INVALID);//enum
            return userDto;
        }
        if (passwordEncoder.matches(userDto.getPassword(), userDAO.getPassword()))
        {
            String token = UUID.randomUUID().toString();
            userRepositoryRC.save(new UserRC(userDto.getUsername(), userDto.getPassword(), token));
            Cookie cookie = new Cookie("ims", token);
            response.addCookie(cookie);
            userDto.setStatus(Status.LOGIN);//enum
        }
        else
            userDto.setStatus(Status.INVALID);//enum
        return userDto;
    }

    @Override
    public ResponseModel signOut(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie[] cookies = request.getCookies();
        ResponseModel responseModel=new ResponseModel();
        for (int i = 0; i < cookies.length; ++i) {
            if (cookies[i].getName().equals("ims")) {
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
               // break;
                responseModel.setStatus(Status.LOGOUT);
            }
        }

        responseModel.setStatus(Status.LOGOUT);
        return  responseModel;
    }//create custom annotation and add to all the apis



    @Override
    public ResponseModel signinViaToken(HttpServletRequest request, HttpServletResponse response)//use dto
    {
        ResponseModel responseModel=new ResponseModel();
        String token;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; ++i) {
            if (cookies[i].getName().equals("ims")) {
                token = cookies[i].getValue();
                if (userRepositoryRC.hasKey(token))
                    responseModel.setStatus(Status.LOGIN);
                else
                    responseModel.setStatus(Status.SESSIOSNEXPIRED);
                return  responseModel;
            }
        }
        responseModel.setStatus(Status.SESSIOSNEXPIRED);
        return responseModel;
    }
}
//how to make custom annotation
//
