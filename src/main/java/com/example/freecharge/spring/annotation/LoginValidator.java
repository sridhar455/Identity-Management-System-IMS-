//package com.example.freecharge.spring.annotation;
//
////package com.example.freecharge.spring.annotation;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.example.freecharge.spring.entity.UserDAO;
//import com.example.freecharge.spring.model.RequestModel;
//import com.example.freecharge.spring.model.ResponseModel;
//import com.example.freecharge.spring.repository.UserRepository;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.aspectj.util.GenericSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//
//@Aspect
//@Component
//public class LoginValidator implements LoginValidation {
//    UserRepository userRepository;
//
//
//    @Around("annotation(LoginValidation)")
//    public Object authorize(ProceedingJoinPoint joinPoint) throws Throwable
//    {
//        Object obj = joinPoint.getArgs()[0];    //Create a more generic way
//        if (obj instanceof RequestModel)        //Create
//        {
////        String user_id=requestModel.getUserName();
//            String user_id = ((RequestModel) obj).getUserName();
//            UserDAO userDAO = userRepository.findByUserName(user_id);
//
//            if (userDAO == null)
//            {
//                System.out.println("Invalid User : ");
//                return " is Invalid User. Please login with correct credential.";
//            }
//            //This is where ACTUAL METHOD will get invoke
//            Object result = joinPoint.proceed();
//
//            // AFTER METHOD EXECUTION
//            System.out.println(result);
//            return result;
//
//        }
//        System.out.println("Invalid User : ");
//        return " is Invalid User. Please login with correct credential.";
//    }
//
//    @Override
//    public Class<? extends Annotation> annotationType() {
//        return null;
//    }
//}
//
