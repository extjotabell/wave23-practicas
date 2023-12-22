package com.meli.socialmeli.services;

import com.meli.socialmeli.dtos.request.PostPromoDTO;
import com.meli.socialmeli.dtos.response.CountPostPromo;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.PostsFromFollowsDTO;


public interface IProductService {

    MessageDTO newPost(PostDTO post);

    PostsFromFollowsDTO getAllPostsFollowsLastTwoWeeks(Integer userId, String order);

    MessageDTO newPostPromo(PostPromoDTO postPromo);

    CountPostPromo countPostPromo(int user_id);

}
