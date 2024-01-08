package com.mercadolibre.romannumerals.unit.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumberControllerTest {

    @Autowired
    RomanNumeralsRestController controller;

    @Test
    @DisplayName("Devuelve el equivalente en número romano: I")
    void testNumberI(){
        Integer source = 1;
        String expected = "I";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: III")
    void testNumberIII(){
        Integer source = 3;
        String expected = "III";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: V")
    void testNumberV(){
        Integer source = 5;
        String expected = "V";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: VII")
    void testNumberVII(){
        Integer source = 7;
        String expected = "VII";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: X")
    void testNumberX(){
        Integer source = 10;
        String expected = "X";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: L")
    void testNumberL(){
        Integer source = 50;
        String expected = "L";

        String actual = controller.toRoman(source);

        assertEquals(expected, actual);
    }


}
