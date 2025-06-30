package com.smaka.backend.service;

import com.smaka.backend.model.User;
import com.smaka.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        System.out.println(userRepository.getAllUsers());
        return userRepository.getAllUsers();
    }


    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void deleteUser(String userName) {
        userRepository.deleteUser(userName);
    }


    public void changeUserPassword(String userName, Map<String, String> map) {
        userRepository.changeUserPassword(userName,map);
    }

    public User login(User user) {
        return userRepository.login(user);
    }
}
