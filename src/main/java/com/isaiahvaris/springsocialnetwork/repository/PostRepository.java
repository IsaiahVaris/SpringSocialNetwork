package com.isaiahvaris.springsocialnetwork.repository;

import com.isaiahvaris.springsocialnetwork.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
