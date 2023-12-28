package meli.bootcamp.sprint1.util;

import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;

public class Validator {
    public static void verifyIfUserExists(User user) {
        if (user == null) {
            throw new BadRequestException("User not found");
        }
    }

    public static void validateIsSeller(User userToFollow) {
        if (!userToFollow.isSeller()) {
            throw new BadRequestException("User " + userToFollow.getId() + " is not a seller");
        }
    }

    public static void validateEqualsId(int userId, int userIdToFollow) {
        if (userId == userIdToFollow) {
            throw new BadRequestException("You can't follow yourself!");
        }
    }
}
