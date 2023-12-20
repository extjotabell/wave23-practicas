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

    public void validatePromoPost(PostDTO postRequestDTO){
        if(!postRequestDTO.isHasPromo() || postRequestDTO.getDiscount() < 0){
            throw new BadRequestException("Promo posts need has_promo as true and discount greater than 0");
        }
    }
}
