package com.meli.socialmeli.utilities;

import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.request.PostPromoDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.dtos.response.UserInfoDTO;
import com.meli.socialmeli.entities.Post;
import com.meli.socialmeli.entities.PostPromo;
import com.meli.socialmeli.entities.Product;
import com.meli.socialmeli.entities.User;

public class Mappers {

    public static Product mapProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProduct_name(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());

    }
    public static Post mapNewPost(PostDTO post, int post_id){
        return new Post(post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(), post_id);
    }

    public static PostPromo mapNewPostPromo(PostPromoDTO postPromoDTO, int post_id){
        return new PostPromo(post_id, postPromoDTO.getDate(),
                mapProduct(postPromoDTO.getProduct()), postPromoDTO.getCategory(), postPromoDTO.getPrice(), postPromoDTO.isHas_promo(), postPromoDTO.getDiscount());
    }

    public static UserInfoDTO mapUserDTO(User user){
        return  new UserInfoDTO(user.getUser_id(), user.getUser_name());
    }
}
