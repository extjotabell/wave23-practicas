package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.exception.ValidationException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentValidator {
    private ArgumentValidator() {}

    public static void validateRequired(Object value, String message) {
        if (value == null) throw new ValidationException(message);
    }

    public static void validateLength(String value, int length, String message) {
        if (value.length() < length) throw new ValidationException(message);
    }

    public static <T> void validateNotEmpty(List<T> list, String message) {
        if (list.isEmpty()) throw new ValidationException(message);
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

    public static void validateEqual(Double value, Double expectedValue, String message) {
        if (!value.equals(expectedValue)) throw new ValidationException(message);
    }

    public static void validateMinLength(Object value, int minLength, String message) {
        if (value.toString().length() < minLength) throw new ValidationException(message);
    }

    public static void validateBefore(LocalDateTime initialDate, LocalDateTime finalDate, String message) {
        if (initialDate.toLocalDate().isAfter(finalDate.toLocalDate())) throw new ValidationException(message);
    }

    public static void validateLess(Long initialNumber, Long finalNumber, String message) {
        if (initialNumber > finalNumber) throw new ValidationException(message);
    }

    public static void validateRegex(String word, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);

        if (!matcher.matches()) throw new ValidationException(message);
    }

    public static <E extends Enum<E>> E validateValid(String value, Class<E> enumToRetrieve, String message) {
        E retrievedEnum = null;

        if (null != value) {
            Optional<E> optionalResult = Arrays.stream(enumToRetrieve.getEnumConstants())
                    .filter(result -> result.toString().equals(value)).findFirst();
            if (optionalResult.isPresent()) {
                retrievedEnum = optionalResult.get();
            } else {
                throw new ValidationException(message);
            }
        }
        return retrievedEnum;
    }

    public static void validateNumeric(String value, String message) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException numberFormatException) {
            throw new ValidationException(message);
        }
    }
}