package com.mercadolibre.springRomanNumerals.exception;

/**
 * The RomanNumeralException class represents a custom exception for Roman numeral-related errors.
 * It extends the RuntimeException class.
 */
public class RomanNumeralException extends RuntimeException{
    public RomanNumeralException(String message) {
        super(message);
    }
}
