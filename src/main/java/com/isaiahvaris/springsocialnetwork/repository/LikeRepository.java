package com.isaiahvaris.springsocialnetwork.repository;

import com.isaiahvaris.springsocialnetwork.model.Like;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Integer> {
    Like findByUserAndPost(User user, Post post);
}
