package com.mercadolibre.be_java_hisp_w23_g2.utils;

import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFollowingException;
import com.mercadolibre.be_java_hisp_w23_g2.exception.NotFoundException;

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

    public void validateInWithoutPromo(PostDTO postDTO) {
        if (postDTO.getUserId() == 0 || postDTO.getDate() == null ||
                postDTO.getProduct().getId() == 0 || postDTO.getProduct().getName() == null ||
                postDTO.getProduct().getType() == null || postDTO.getProduct().getBrand() == null ||
                postDTO.getProduct().getColor() == null || postDTO.getProduct().getNotes() == null ||
                postDTO.getCategory() == null || postDTO.getPrice() == 0.0 ||
                postDTO.isHas_promo() || postDTO.getDiscount() > 0) {
            throw new BadRequestException("The publication data entered is not correct.");
        }
    }

    public void validateInPromo(PostDTO postDTO) {
        if (postDTO.getUserId() == 0 || postDTO.getDate() == null ||
                postDTO.getProduct().getId() == 0 || postDTO.getProduct().getName() == null ||
                postDTO.getProduct().getType() == null || postDTO.getProduct().getBrand() == null ||
                postDTO.getProduct().getColor() == null || postDTO.getProduct().getNotes() == null ||
                postDTO.getCategory() == null || postDTO.getPrice() == 0.0 ||
                (postDTO.isHas_promo() && postDTO.getDiscount() == 0.0) ||
                (!postDTO.isHas_promo() && postDTO.getDiscount() != 0.0)) {
            throw new BadRequestException("The publication data entered is not correct.");
        }
    }
}
