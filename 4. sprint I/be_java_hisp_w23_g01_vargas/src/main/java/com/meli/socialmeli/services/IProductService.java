package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PromoPostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;
import com.meli.socialmeli.dtos.response.PromoCountDTO;


public interface IProductService {

    MessageDTO newPost(PostDTO post);

    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);

    MessageDTO newPromoPost(PromoPostDTO promoPost);

    PromoCountDTO  getPromoPostsCount(int userId);
}
