package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

    @Test
    @DisplayName("toRoman 1")
    void toRoman1Test() {
        // Arragne
        Integer numerToRoman = 1;
        String expectedReturn = "I";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }

    @Test
    @DisplayName("toRoman 3")
    void toRoman2Test() {
        // Arragne
        Integer numerToRoman = 3;
        String expectedReturn = "III";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }

    @Test
    @DisplayName("toRoman 5")
    void toRoman3Test() {
        // Arragne
        Integer numerToRoman = 5;
        String expectedReturn = "V";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }

    @Test
    @DisplayName("toRoman 7")
    void toRoman4Test() {
        // Arragne
        Integer numerToRoman = 7;
        String expectedReturn = "VII";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }

    @Test
    @DisplayName("toRoman 10")
    void toRoman5Test() {
        // Arragne
        Integer numerToRoman = 10;
        String expectedReturn = "X";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }

    @Test
    @DisplayName("toRoman 50")
    void toRoman6Test() {
        // Arragne
        Integer numerToRoman = 50;
        String expectedReturn = "L";

        // Act
        String returnValue = this.romanNumeralsRestController.toRoman(numerToRoman);

        // Assert
        assertEquals(returnValue, expectedReturn);
    }
    
}
