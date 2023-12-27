package com.mercadolibre.romannumerals;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ControllerTestParams {

    private RomanNumeralsRestController controller;

    private static Object[] testValues(){
        return new Object[]{
                new Object[]{1,"I"},
                new Object[]{3, "III"},
                new Object[]{5, "V"},
                new Object[]{10, "X"},
                new Object[]{55, "LV"},
                new Object[]{100, "C"},
        };
    }


    @Test
    @Parameters(method = "testValues")
    public void calculate(int datoEntrada, String datoEsperado){
        controller = new RomanNumeralsRestController();
        String datoActual = controller.toRoman(datoEntrada);
        assertEquals(datoEsperado, datoActual);
    }


}
