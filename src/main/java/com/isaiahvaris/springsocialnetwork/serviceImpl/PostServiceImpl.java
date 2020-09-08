package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.repository.PostRepository;
import com.isaiahvaris.springsocialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void addPost(Post post) {

    }

    @Override
    public Iterable<Post> getPosts() {
        return null;
    }

    @Override
    public Optional<User> getPostsByUser(int id) {
        return Optional.empty();
    }

    @Override
    public void editPost() {

    }

    @Override
    public Boolean deletePost(int post_id) {
        return null;
    }
}
