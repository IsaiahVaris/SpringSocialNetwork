package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.User;

import java.util.Optional;

public interface UserService  {

    void addUser (User user);
    Iterable<User> getUsers ();
    Optional<User> getUserById(int id);
    Optional<User> getUserByEmail(String email);
    void deleteUser(User user);

}
