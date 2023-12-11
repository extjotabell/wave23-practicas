package com.mercadolibre.springRomanNumerals.service;

import com.mercadolibre.springRomanNumerals.exception.RomanNumeralException;

import java.util.HashMap;
import java.util.Map;

/**
 * The RomanNumeralConverter class implements the IRomanNumeralConverter interface,
 * providing a method to convert decimal numbers to Roman numerals.
 */
public class RomanNumeralConverter implements IRomanNumeralConverter{

    private final Map<Integer, String> equivalences;

    /**
     * Constructs a RomanNumeralConverter object and initializes the equivalences map
     * with predefined mappings of decimal values to Roman numeral representations.
     */
    public RomanNumeralConverter() {
        equivalences = new HashMap<>();
        equivalences.put(1, "I");
        equivalences.put(4, "IV");
        equivalences.put(5, "V");
        equivalences.put(9, "IX");
        equivalences.put(10, "X");
        equivalences.put(50, "L");
        equivalences.put(100, "C");
        equivalences.put(500, "D");
        equivalences.put(1000, "M");
    }

    /**
     * Converts a given decimal number to its equivalent Roman numeral representation.
     *
     * @param number The decimal number to be converted.
     * @return The Roman numeral representation of the input number.
     * @throws RomanNumeralException If the input number is less than or equal to zero.
     */
    @Override
    public String convertToRomanNumeral(int number) {
        if (number <= 0) {
            throw new RomanNumeralException("El número debe ser mayor que cero");
        }

        StringBuilder resultant = new StringBuilder();

        for (int value : equivalences.keySet()) {
            while (number >= value) {
                resultant.append(equivalences.get(value));
                number -= value;
            }
        }

        return resultant.toString();
    }
}
