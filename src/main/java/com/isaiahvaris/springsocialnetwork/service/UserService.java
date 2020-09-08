package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface UserService  {

    void addUser (User user);
    Iterable<User> getUsers ();
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    Boolean deleteUser(String email);





//    //login user
//    public boolean login(String email, String pass_word) {
//    }
//
//    //register user
//    public String register(User user) {
//        }
//    }
//
//    //delete user from database with id matching id paramater
//    public boolean deleteUser(int id) throws SQLException {
}
