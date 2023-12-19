package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;


public interface IProductService {

    MessageDTO newPost(PostDTO post);
    MessageDTO createPromoPost(PromoPostDTO promoPostDTO);

    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);

}
