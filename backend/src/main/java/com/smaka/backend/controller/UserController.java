package com.smaka.backend.controller;

import com.smaka.backend.model.User;
import com.smaka.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    private final UserService userService;


    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> getAllUsers() {
        List<User> u = userService.getAllUsers();
        System.out.println(u);
        return userService.getAllUsers();
    }

}
