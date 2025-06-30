package com.smaka.backend.controller;

import com.smaka.backend.model.User;
import com.smaka.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        List<User> u = userService.getAllUsers();
        System.out.println(u);
        return u;
    }

}
