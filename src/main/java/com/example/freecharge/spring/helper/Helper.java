package com.example.freecharge.spring.helper;

import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import com.example.freecharge.spring.dto.UserDto;
import com.example.freecharge.spring.model.RequestModel;
import com.example.freecharge.spring.model.ResponseModel;
import com.example.freecharge.spring.service.UserService;
import com.example.freecharge.spring.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;


@Component
public class Helper
{
    @Autowired
    private UserService userService;

    @Autowired
    private Translator translator;

    public ResponseModel register(RequestModel signUpRequest)
    {
       // Boolean isValid = validateRequestModel(signUpRequest);//throw exception if Validation is false
      //  if(isValid)

            UserDto userDto = translator.requestToDto(signUpRequest);
            userDto = userService.register(userDto);
        ResponseModel responseModel= translator.dtoToResponse(userDto);
        return responseModel;
         //   if(userDto.getStatus()=="Registration Complete")//make status enum!!
    }

    public ResponseModel signInViaCreds(RequestModel requestModel, HttpServletResponse response)
    {
        UserDto userDto= translator.requestToDto(requestModel);
        userDto = userService.signInViaCreds(userDto,response);
        ResponseModel responseModel=translator.dtoToResponse(userDto);
        return responseModel;
    }

    public ResponseModel signOut(HttpServletRequest request, HttpServletResponse response)
    {
        ResponseModel responseModel= userService.signOut(request,response);
        return responseModel;
    }

    public ResponseModel signinViaToken(HttpServletRequest request, HttpServletResponse response) {
        ResponseModel responseModel= userService.signinViaToken(request,response);
        return responseModel;


    }
}
