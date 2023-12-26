package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestController
class RomanNumeralsRestControllerTest {

    private RomanNumeralsRestController controller;

    @BeforeEach
    void setUp() {
        controller = new RomanNumeralsRestController();
    }

    @Test
    void toRomanWithOne() {
        assertConversion(1, "I");
    }

    @Test
    void toRomanWithThree() {
        assertConversion(3, "III");
    }

    @Test
    void toRomanWithFive() {
        assertConversion(5, "V");
    }

    @Test
    void toRomanWithSeven() {
        assertConversion(7, "VII");
    }

    @Test
    void toRomanWithTen() {
        assertConversion(10, "X");
    }

    @Test
    void toRomanWithFifty() {
        assertConversion(50, "L");
    }

    private void assertConversion(int number, String expected) {
        // Act
        String result = controller.toRoman(number);

        // Assert
        assertEquals(expected, result);
    }
}
