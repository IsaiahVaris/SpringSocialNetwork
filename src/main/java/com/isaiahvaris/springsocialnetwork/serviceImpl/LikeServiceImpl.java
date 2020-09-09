package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.model.Like;
import com.isaiahvaris.springsocialnetwork.repository.LikeRepository;
import com.isaiahvaris.springsocialnetwork.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(Like like) {
        likeRepository.delete(like);
    }
}
