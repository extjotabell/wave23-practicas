package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.PromoProductsCountDTO;


public interface IProductService {

    MessageDTO newPost(PostDTO post);
    MessageDTO createPromoPost(PromoPostDTO promoPostDTO);
    PromoProductsCountDTO getCountPromoPosts(Integer userId);
    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);

}
