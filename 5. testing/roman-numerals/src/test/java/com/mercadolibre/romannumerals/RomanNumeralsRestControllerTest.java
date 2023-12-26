package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @ParameterizedTest
    @DisplayName("Test toRoman multiple numbers successfully")
    @CsvSource({
            "1, I",
            "3, III",
            "5, V",
            "7, VII",
            "10, X",
            "50, L"
    })
    void toRomanOk(Integer param, String expectedResult) {
        String result = controller.toRoman(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test toRoman with null value")
    void toRomanNullValue() {
        Integer param = null;

        assertThrows(NullPointerException.class,
                () -> controller.toRoman(param));
    }

    @Test
    @DisplayName("Test toRoman with negative value")
    void toRomanWithNegativeValue() {
        Integer param = -10;
        String expectedResult = "";

        String result = controller.toRoman(param);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test toRoman with complex value: 3999")
    void toRomanWithComplexValue() {
        Integer param = 3999;
        String expectedResult = "MMMCMXCIX";

        String result = controller.toRoman(param);
        assertEquals(expectedResult, result);
    }
}