package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService  {

    void addUser (User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByEmailandPassWord(String email, String passWord);
    boolean deleteUser(User user);

}
