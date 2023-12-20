package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFollowingException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Utility class for validating user-related operations.
 */
public class Validator {

    private static Validator instance = null;
    private Validator(){

    }

    public static Validator getInstance() {
        if(instance==null){
            instance=new Validator();
        }
        return instance;
    }

    public void checkIfUserHasFollowed(User user) {
        if (user.getFollowed() == null || user.getFollowed().isEmpty()) {
            throw new NotFoundException("User with id = " + user.getId() + " has no followed");
        }
    }

    public void validateThatItIsNotTheSameUser(int userId, int userId2){
        if (userId == userId2){
            throw new BadRequestException("A user cannot follow/unfollow himself");
        }
    }

    public void validateUserExistence(User user, int userId, String userType) {
        if (user == null) {
            throw new NotFoundException(String.format("%s user with id = %d not exists.", userType, userId));
        }
    }

    public void validateFollowing(User currentUser, int userIdToUnfollow) {
        if (currentUser.getFollowed() == null ||
                currentUser.getFollowed().stream().filter(user -> user.getId() == userIdToUnfollow).findFirst().orElse(null) == null) {
            throw new NotFollowingException("The current user does not follow the user to unfollow.");
        }

    }

    public void validatePost(PostDTO postDTO) {
        if (postDTO.getUserId() == 0 || postDTO.getDate() == null ||
                postDTO.getProduct().getId() == 0 || postDTO.getProduct().getName() == null ||
                postDTO.getProduct().getType() == null || postDTO.getProduct().getBrand() == null ||
                postDTO.getProduct().getColor() == null || postDTO.getProduct().getNotes() == null ||
                postDTO.getCategory() == null || postDTO.getPrice() == 0.0) {
            throw new BadRequestException("The publication data entered is not correct.");
        }
    }

    public void validatePostPromo(PostPromoDTO postPromoDTO) {
        if (postPromoDTO.getUserId() == 0 || postPromoDTO.getDate() == null ||
                postPromoDTO.getProduct().getId() == 0 || postPromoDTO.getProduct().getName() == null ||
                postPromoDTO.getProduct().getType() == null || postPromoDTO.getProduct().getBrand() == null ||
                postPromoDTO.getProduct().getColor() == null || postPromoDTO.getProduct().getNotes() == null ||
                postPromoDTO.getCategory() == null || postPromoDTO.getPrice() == 0.0 || !postPromoDTO.isPromo() ||
                postPromoDTO.getDiscount() == 0.0) {
            throw new BadRequestException("The publication data entered is not correct.");
        }
    }

    public void validatePostExistence(List<Post> posts, Post post){
        Optional<Post> postExist = posts.stream()
                .filter(p -> p.getProduct().getId() == post.getProduct().getId()).findFirst();
        if (postExist.isPresent()) {
            throw new BadRequestException("The product id already exists.");
        }
    }

    public void validatePromoProductCount(int promoProductCount) {
        if (promoProductCount < 0) {
            throw new BadRequestException("Invalid promo product count");
        }
    }

    public void validateKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new BadRequestException("Keyword cannot be null or empty. Please provide a valid keyword.");
        }
    }
}
