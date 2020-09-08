package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.repository.LikeRepository;
import com.isaiahvaris.springsocialnetwork.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;
}
