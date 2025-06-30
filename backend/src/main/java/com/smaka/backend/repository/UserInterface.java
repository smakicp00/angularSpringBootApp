package com.smaka.backend.repository;

import com.smaka.backend.model.User;

import java.util.List;
import java.util.Map;

public interface UserInterface {

    public List<User> getAllUsers();
    public void addUser(User user);

    void deleteUser(String userName);



    void changeUserPassword(String userName, Map<String, String> map);

    User login(User user);
}
