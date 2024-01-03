package com.mercadolibre.romannumerals.unitest;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralUnitest {

    @Autowired
    private RomanNumeralsRestController controller;

    @Test
    @DisplayName("toRoman uni test OK")
    public void romanTestOK() {

        Integer data = 10;

        String expected = "X";

        String actual = controller.toRoman(data);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toRoman uni test NO OK")
    public void romanTestNoOK() {

        Integer data = 9;

        String expected = "X";

        String actual = controller.toRoman(data);

        Assertions.assertNotEquals(expected, actual);
    }
}
