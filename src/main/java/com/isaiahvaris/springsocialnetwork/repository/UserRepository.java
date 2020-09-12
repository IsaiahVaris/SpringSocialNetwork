package com.isaiahvaris.springsocialnetwork.repository;

import com.isaiahvaris.springsocialnetwork.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassWord(String email, String passWord);
}
