package com.example.freecharge.spring.exception;


import com.example.freecharge.spring.dto.UserDto;
import com.example.freecharge.spring.enumOBJ.Status;
import com.example.freecharge.spring.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
//public class UserInvalidException
//{
////    @ExceptionHandler(value = UserNotFoundException.class)//response
////    public UserDto exception(UserNotFoundException exception)
////    {
////        return new UserDto(Status.INVALID,"Invalid User");
////    }
//}

