package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.DBUserDTO;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostPromoDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserFollowDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.Product;
import com.sprint.be_java_hisp_w23_g04.entity.PostPromo;
import com.sprint.be_java_hisp_w23_g04.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapUser(DBUserDTO userDto) {
        List<PostResponseDTO> postsDto = userDto.getPosts();
        List<User> followed;
        List<User> followers;

        if (userDto.getFollowed() == null) {
            followed = new ArrayList<>();
        } else {
            followed = userDto.getFollowed().stream().map(p -> new User(p.getId(), p.getName())).collect(Collectors.toList());
        }

        if (userDto.getFollowers() == null) {
            followers = new ArrayList<>();
        } else {
            followers = userDto.getFollowers().stream().map(p -> new User(p.getId(), p.getName())).collect(Collectors.toList());
        }

        List<Post> posts = postsDto.stream().map(p -> new Post(p.getPostId(), p.getDate(), mapProduct(p.getProduct()), p.getCategory(), p.getPrice())).collect(Collectors.toList());
        return new User(userDto.getUser_id(), userDto.getName(), posts, followed, followers);
    }

    public static UserDTO mapUser(User user) {
        List<PostResponseDTO> postResponseDTOS = user.getPosts().stream()
                .map(p -> {
                    if (p instanceof PostPromo) {
                        PostPromo promo = (PostPromo) p;
                        return new PostResponseDTO(user.getId(), p.getDate(), mapProduct(p.getProduct()), p.getCategory(), p.getPrice(), p.getId(), promo.isHasPromo(), promo.getDiscount());
                    } else {
                        return new PostResponseDTO(user.getId(), p.getId(), p.getDate(), mapProduct(p.getProduct()), p.getCategory(), p.getPrice());
                    }
                }).toList();
        List<UserFollowDTO> followedDTOS = user.getFollowed().stream().map(
                p -> new UserFollowDTO(p.getId(), p.getName())).toList();
        List<UserFollowDTO> followersDTOS = user.getFollowers().stream().map(
                p -> new UserFollowDTO(p.getId(), p.getName())).toList();
        return new UserDTO(user.getId(), user.getName(), postResponseDTOS, followedDTOS, followersDTOS);
    }

    public static Product mapProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(),
                productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public static ProductDTO mapProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getType(),
                product.getBrand(), product.getColor(), product.getNotes());
    }

    public static Post mapPost(PostDTO post, int postId) {
        return new Post(postId, post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice());
    }

    public static PostPromo mapPost(PostPromoDTO post, int postId) {
        return new PostPromo(postId, post.getDate(), mapProduct(post.getProduct()), post.getCategory(), post.getPrice(),
                post.isHasPromo(), post.getDiscount());
    }

    public static PostPromoDTO mapPost(PostPromo post, int postId) {
        return new PostPromoDTO(postId, post.getDate(), mapProduct(post.getProduct()) , post.getCategory(), post.getPrice(),
                post.isHasPromo(), post.getDiscount());
    }

    public static UserFollowDTO mapUserFollow(User user) {
        return new UserFollowDTO(user.getId(), user.getName());
    }

    public static SellerDTO mapSeller(User user, PostPromo post) {
        return new SellerDTO(user.getId(), user.getName(), mapPost(post, post.getId()));
    }
}
