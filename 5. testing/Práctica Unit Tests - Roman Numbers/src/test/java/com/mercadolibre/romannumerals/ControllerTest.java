package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private RomanNumeralsRestController controller;


    @Test
    @DisplayName("Devuelve el equivalente en número romano: I")
    void case1(){
        //Arrange
        Integer datoEntrada = 1;
        String datoEsperado = "I";
        //Act
        String datoActual = controller.toRoman(datoEntrada);
        //Assert
        assertEquals(datoEsperado, datoActual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: III")
    void case2(){
        //Arrange
        Integer datoEntrada = 3;
        String datoEsperado = "III";
        //Act
        String datoActual = controller.toRoman(datoEntrada);
        //Assert
        assertEquals(datoEsperado, datoActual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: V")
    void case3(){
        //Arrange
        Integer datoEntrada = 5;
        String datoEsperado = "V";
        //Act
        String datoActual = controller.toRoman(datoEntrada);
        //Assert
        assertEquals(datoEsperado, datoActual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: X")
    void case4(){
        //Arrange
        Integer datoEntrada = 10;
        String datoEsperado = "X";
        //Act
        String datoActual = controller.toRoman(datoEntrada);
        //Assert
        assertEquals(datoEsperado, datoActual);
    }

    @Test
    @DisplayName("Devuelve el equivalente en número romano: L")
    void case5(){
        //Arrange
        Integer datoEntrada = 50;
        String datoEsperado = "L";
        //Act
        String datoActual = controller.toRoman(datoEntrada);
        //Assert
        assertEquals(datoEsperado, datoActual);
    }


}
