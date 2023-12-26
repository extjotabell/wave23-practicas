package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RomanNumeralsRestControllerTest {

    @Autowired
    RomanNumeralsRestController controller;
    @Test
    void romanTestOkCaseEquals(){
        //Arrange
        Integer num = 12;
        String expected = "XII";
        //Act
        String result = controller.toRoman(num);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void romanTestOkCaseNotEquals(){
        //Arrange
        Integer num = 16;
        String expected = "IX";
        //Act
        String result = controller.toRoman(num);
        //Assert
        assertNotEquals(expected, result);
    }

    @Test
    void romanTestOkCaseNull(){
        //Arrange
        Integer num = null;
        //Act & Asser
        assertThrows(NullPointerException.class, ()->controller.toRoman(num));
    }
}
