package com.mercadolibre.springRomanNumerals.service;

/**
 * The IRomanNumeralConverter interface defines a contract for converting decimal numbers to Roman numerals.
 */
public interface IRomanNumeralConverter {

    /**
     * Converts a given decimal number to its equivalent Roman numeral representation.
     *
     * @param number The decimal number to be converted.
     * @return The Roman numeral representation of the input number.
     */
    String convertToRomanNumeral(int number);
}
