package com.example.freecharge.spring.translator;

import com.example.freecharge.spring.dto.UserDto;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import org.springframework.stereotype.Component;

@Component
public class Translator
{

    public UserDto requestToDto(RequestModel signUpRequestModel)
    {
        UserDto userDto=new UserDto();
        userDto.setUsername(signUpRequestModel.getUserName());
        userDto.setEmail(signUpRequestModel.getEmail());
        userDto.setPassword(signUpRequestModel.getPassword());
        return userDto;
    }

    public ResponseModel dtoToResponse(UserDto userDto)
    {
        ResponseModel responseModel=new ResponseModel();
        responseModel.setStatus(userDto.getStatus());
        return responseModel;
    }
}