package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;

import java.util.Optional;

public interface PostService {

    Post addPost (Post post);
    Iterable<Post> getPosts ();
    Iterable<Post> getPostsByUser(User user);
    Post editPost(Post post, String message_body);
    void deletePost(Post post);
}
