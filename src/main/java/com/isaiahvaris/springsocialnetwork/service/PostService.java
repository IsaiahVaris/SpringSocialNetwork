package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;

import java.util.Optional;

public interface PostService {

    void addPost (Post post);
    Iterable<Post> getPosts ();
    Optional<User> getPostsByUser(int id);
    void editPost();
    Boolean deletePost(int post_id);
}
