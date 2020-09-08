package com.isaiahvaris.springsocialnetwork.repository;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
