package com.smaka.backend.repository;

import com.smaka.backend.db.DB;
import com.smaka.backend.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements UserInterface {

    @Override
    public List<User> getAllUsers() {
        try (Connection connection = DB.source().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"), resultSet.getString("password"));
                users.add(user);
            }
            System.out.println(users);
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        try (Connection connection = DB.source().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username, password) VALUES (?,?)")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String userName) {
        try (Connection connection = DB.source().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE userName = ?")) {
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void changeUserPassword(String userName, Map<String, String> map) {
        try (Connection connection = DB.source().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET password = ? WHERE userName = ?;")) {
            preparedStatement.setString(1, map.get("newPassword"));
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();
            System.out.println("Password :" + map.get("newPassword") + " for user " + userName + " has been changed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
