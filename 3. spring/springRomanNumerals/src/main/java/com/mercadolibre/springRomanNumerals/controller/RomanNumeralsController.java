package com.mercadolibre.springRomanNumerals.controller;

import com.mercadolibre.springRomanNumerals.service.RomanNumeralConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The RomanNumeralsController class handles HTTP requests related to Roman numeral conversion.
 */
@RestController
@RequestMapping("/RomanNumerals")
public class RomanNumeralsController {
    private final RomanNumeralConverter numeralConverter;

    /**
     * Constructs a new RomanNumeralsController with a RomanNumeralConverter instance.
     */
    public RomanNumeralsController() {
        this.numeralConverter = new RomanNumeralConverter();
    }

    /**
     * Converts a decimal number to a Roman numeral and returns the result.
     *
     * @param number The decimal number to convert.
     * @return The Roman numeral representation of the given number.
     */
    @GetMapping("/convert/{number}")
    public String convertToRomanNumeral(@PathVariable int number) {
        return numeralConverter.convertToRomanNumeral(number);
    }
}