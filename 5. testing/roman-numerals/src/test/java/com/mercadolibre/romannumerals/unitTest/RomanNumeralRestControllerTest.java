package com.mercadolibre.romannumerals.unitTest;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralRestControllerTest {

    @Test
    void toRomanTestOk(){
        //Arrange
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

        //Assert
        for(int i = 0; i<=numbersToCompare.length-1;i++){
            assertEquals(romanNumbers[i],romanNumeralsRestController.toRoman(numbersToCompare[i]));
        }
    }
}
