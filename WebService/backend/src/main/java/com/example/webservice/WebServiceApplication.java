package com.example.webservice;

import com.example.webservice.v1.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(WebServiceApplication.class, args);
    }

}
