package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralRestControllerTest {

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral I")
    void testNumberI() {
        //Arrange
        int number = 1;
        String romanNumberExpected = "I";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral III")
    void testNumberIII(){
        //Arrange
        int number = 3;
        String romanNumberExpected = "III";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral IV")
    void testNumberIV() {
        //Arrange
        int number = 4;
        String romanNumberExpected = "IV";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral V")
    void testNumberV(){
        //Arrange
        int number = 5;
        String romanNumberExpected = "V";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral VII")
    void testNumberVII(){
        //Arrange
        int number = 7;
        String romanNumberExpected = "VII";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral X")
    void testNumberX(){
        //Arrange
        int number = 10;
        String romanNumberExpected = "X";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }

    @Test
    @DisplayName("Test to verify the return of the Roman Numeral L")
    void testNumberL(){
        //Arrange
        int number = 50;
        String romanNumberExpected = "L";
        RomanNumeralsRestController controller = new RomanNumeralsRestController();

        //Act
        String result = controller.toRoman(number);

        //Assert
        assertEquals(romanNumberExpected, result);
    }
}
