package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.exception.NoContentException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import jakarta.validation.UnexpectedTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionControllerTest {

    @Autowired
    ExceptionController exceptionController;

    @Test
    @DisplayName("Not found exception")
    void test1() {
        // Arrange
        NotFoundException e = new NotFoundException("menssage");
        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO(e.getMessage());
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(simpleMessageDTO, HttpStatus.NOT_FOUND);

        // Act
        ResponseEntity<?> response = exceptionController.notFoundException(e);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Bad request exception")
    void test2() {
        // Arrange
        BadRequestException e = new BadRequestException("menssage");
        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO(e.getMessage());
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(simpleMessageDTO, HttpStatus.BAD_REQUEST);

        // Act
        ResponseEntity<?> response = exceptionController.badRequest(e);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Empty content exception")
    void test3() {
        // Arrange
        NoContentException e = new NoContentException();
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        // Act
        ResponseEntity<?> response = exceptionController.emptyContent(e);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Validation exception")
    void test4() {
        // Arrange
        UnexpectedTypeException e = new UnexpectedTypeException("message");
        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO(e.getMessage());
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(simpleMessageDTO, HttpStatus.BAD_REQUEST);

        // Act
        ResponseEntity<?> response = exceptionController.validationException(e);

        // Assert
        assertEquals(expectedResponse, response);
    }
}
