package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.Like;

public interface LikeService {
    Like addLike(Like like);
    void deleteLike(Like like);
}
