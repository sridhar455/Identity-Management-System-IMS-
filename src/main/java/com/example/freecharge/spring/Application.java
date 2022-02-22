package com.example.freecharge.spring;
//package com.example.freecharge.spring.Application;
//import org.springframework.boot.Spring.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({ "com.example.freecharge.spring.*" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    private static void run(Class<Application> applicationClass, String[] args) {
//    }

}
