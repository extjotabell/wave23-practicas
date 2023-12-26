package com.mercadolibre.romannumerals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RomanNumeralsRestControllerTest {

    @Autowired
    RomanNumeralsRestController romanNumeralsRestController;

    @Test
    @DisplayName("Find Roman Number convertion for 1")
    void findRomanNumberForOne(){
        //Arrange
        Integer one = 1;
        String expectedResult = "I";

        //Act
        String result = romanNumeralsRestController.toRoman(one);

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("Find Roman Number convertion for 7")
    void findRomanNumberForSeven(){
        //Arrange
        Integer seven = 7;
        String expectedResult = "VII";

        //Act
        String result = romanNumeralsRestController.toRoman(seven);

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("Find Roman Number convertion for 1276")
    void findRomanNumberFor1276(){
        //Arrange
        Integer seven = 1276;
        String expectedResult = "MCCLXXVI";

        //Act
        String result = romanNumeralsRestController.toRoman(seven);

        //Assert
        assertEquals(expectedResult,result);
    }

}
