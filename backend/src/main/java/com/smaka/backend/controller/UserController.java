package com.smaka.backend.controller;

import com.smaka.backend.model.User;
import com.smaka.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        System.out.println(user);
        userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{userName}")
    public void deleteUser(@PathVariable String userName){//DELETE
        userService.deleteUser(userName);
    }

    @PatchMapping("/changeUserPassword/{userName}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void changeUserPassword(@PathVariable String userName, @RequestBody Map<String, String> map){
        System.out.println(userName);
        System.out.println(map.get("newPassword"));
        userService.changeUserPassword(userName, map);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

}
