package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsApplicationUnitTest {

    RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

    @Test
    void toRomanNum1Test(){

        int param = 1;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("I", response);
    }

    @Test
    void toRomanNum3Test(){

        int param = 3;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("III", response);
    }

    @Test
    void toRomanNum5Test(){

        int param = 5;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("V", response);
    }

    @Test
    void toRomanNum7Test(){

        int param = 7;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("VII", response);
    }

    @Test
    void toRomanNum10Test(){

        int param = 10;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("X", response);
    }

    @Test
    void toRoman50Test(){

        int param = 50;

        String response = romanNumeralsRestController.toRoman(param);

        Assertions.assertEquals("L", response);
    }

}
