package com.smaka.backend.repository;

import com.smaka.backend.db.DB;
import com.smaka.backend.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserInterface {

    @Override
    public List<User> getAllUsers(){
        try (Connection connection = DB.source().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user")){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                User user = new User(resultSet.getString("username"), resultSet.getString("password"));
                users.add(user);
            }
            return users;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
