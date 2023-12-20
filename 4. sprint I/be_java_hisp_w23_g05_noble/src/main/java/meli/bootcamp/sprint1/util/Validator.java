package meli.bootcamp.sprint1.util;

import meli.bootcamp.sprint1.entity.Category;
import meli.bootcamp.sprint1.entity.User;
import meli.bootcamp.sprint1.exception.BadRequestException;

public class Validator {
    public static void validateUser(User u) {
        if (u == null) {
            throw new BadRequestException("User not found");
        }
    }

    public static void validateIsSeller(User u) {
        if (!u.isSeller()) {
            throw new BadRequestException("User is not a seller");
        }
    }

    public static void validateIsNotSeller(User u) {
        if (u.isSeller()) {
            throw new BadRequestException("User can't be a seller");
        }
    }

    public static void validateCategory(Category c) {
        if (c == null) {
            throw new BadRequestException("Category not found");
        }
    }
}
