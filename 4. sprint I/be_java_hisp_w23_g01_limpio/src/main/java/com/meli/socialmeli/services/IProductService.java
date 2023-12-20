package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.PromoCountDTO;

import java.util.List;

public interface IProductService {

    MessageDTO newPost(PostDTO post);
    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);
    PromoPostDTO newPromoPost(PromoPostDTO post);
    PromoCountDTO newPromoPostCount(int userId);
}
