package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumeralsRestControllerTest {

    @Autowired
    RomanNumeralsRestController controller;

    @Test
    void toRomanTest1() {
        // Arrange
        Integer number = 1;
        String expected = "I";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toRomanTest2() {
        // Arrange
        Integer number = 3;
        String expected = "III";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toRomanTest3() {
        // Arrange
        Integer number = 5;
        String expected = "V";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toRomanTest4() {
        // Arrange
        Integer number = 7;
        String expected = "VII";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toRomanTest5() {
        // Arrange
        Integer number = 10;
        String expected = "X";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toRomanTest6() {
        // Arrange
        Integer number = 50;
        String expected = "L";

        // Act
        String actual = controller.toRoman(number);

        // Assert
        assertEquals(expected, actual);
    }

}
