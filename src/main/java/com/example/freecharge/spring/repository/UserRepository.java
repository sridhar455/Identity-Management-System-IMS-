package com.example.freecharge.spring.repository;
//package com.example.freecharge.spring.repository;

import com.example.freecharge.spring.entity.UserDAO;
import com.example.freecharge.spring.entity.UserDAO;
import com.example.freecharge.spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {


    UserDAO save(UserDAO user);
    UserDAO findByusername(String username);

    //  void save(UserDAO userDAO);
}