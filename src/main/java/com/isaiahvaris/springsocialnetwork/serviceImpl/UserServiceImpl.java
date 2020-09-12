package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.repository.UserRepository;
import com.isaiahvaris.springsocialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*
    Create new user
     */
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    /*
        Get user by email and password(login details)
     */
    @Override
    public User getUserByEmailandPassWord(String email, String passWord) {
        return userRepository.findByEmailAndPassWord(email, passWord).orElse(null);
    }

    @Override
    public boolean deleteUser(User user) {
         userRepository.delete(user);
         return true;
    }

}
