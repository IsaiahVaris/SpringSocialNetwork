package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.repository.CommentRepository;
import com.isaiahvaris.springsocialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
}