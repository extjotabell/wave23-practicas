package com.ospina.socialmeli.util;

import com.ospina.socialmeli.exception.exceptions.ValidationException;

public class ArgumentValidator {
    private ArgumentValidator() {}

    public static void validateRequired(Object value, String message) {
        if (value == null) throw new ValidationException(message);
    }

    public static void validatePositive(Double value, String message) {
        if (value <= 0) throw new ValidationException(message);
    }

    public static void validatePositive(Long value, String message) {
        if (value <= 0) throw new ValidationException(message);
    }

    public static void validatePositive(int value, String message) {
        if (value <= 0) throw new ValidationException(message);
    }

    public static void validateMinLength(Object value, int minLength, String message) {
        if (value.toString().length() < minLength) throw new ValidationException(message);
    }

}