package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PostPromoDTO;
import com.meli.socialmeli.dtos.response.CountPostPromoDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;


public interface IProductService {

    MessageDTO newPost(PostDTO post);

    MessageDTO newPostPromo(PostPromoDTO post);

    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);

    CountPostPromoDTO countPromoPost(int userId);

}
