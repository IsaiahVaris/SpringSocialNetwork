package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface PostService {

    Post addPost (Post post);
    Post getPostById(int id);
    List<Post> getPosts ();
    List<Post> getPostsByUser(User user);
    Post editPost(Post post, String messageBody);
    void deletePost(Post post);
}
