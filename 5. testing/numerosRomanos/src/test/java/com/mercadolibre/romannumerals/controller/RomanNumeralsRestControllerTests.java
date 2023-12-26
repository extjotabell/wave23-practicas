package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static com.mercadolibre.romannumerals.utils.RomanNumeralTestCases.testCases;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RomanNumeralsRestControllerTests {

    @Autowired
    RomanNumeralsRestController controller;

    @Test
    @DisplayName("All test cases return the correct roman numeral")
    void testCasesOk() {
        for (Map.Entry<Integer, String> testCase : testCases.entrySet()) {
            String roman = controller.toRoman(testCase.getKey());
            assertEquals(testCase.getValue(), roman);
        }
    }

    @Test
    @DisplayName("Test decimal 0 returns empty string")
    void testCasesOkReverse() {
        Integer decimal = 0;
        String roman = controller.toRoman(decimal);
        assertEquals("", roman);
    }

    @Test
    @DisplayName("Test negative decimal returns empty string")
    void testCasesOkNegative() {
        Integer decimal = -1;
        String roman = controller.toRoman(decimal);
        assertEquals("", roman);
    }
}
