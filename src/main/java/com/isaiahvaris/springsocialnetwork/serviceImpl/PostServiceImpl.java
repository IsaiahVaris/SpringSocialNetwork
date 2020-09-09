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
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Iterable<Post>  getPostsByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    @Override
    public Post editPost(Post post, String message_body) {

        post.setMessage_body(message_body);

        return postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {

         postRepository.delete(post);
    }
}
