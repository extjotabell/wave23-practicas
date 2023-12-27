package com.mercadolibre.blog.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionTest {

    @Autowired
    ExceptionConfig exceptionConfig;

    @Test
    @DisplayName("EntryBlogAlreadyExistsException")
    void test1() {
        // Arrange
        EntryBlogAlreadyExistsException e = new EntryBlogAlreadyExistsException("mensaje");
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        // Act
        ResponseEntity<?> response = exceptionConfig.entryBlogException(e);

        // Assert
        assertEquals(expectedResponse, response);
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());

    }

    @Test
    @DisplayName("EntryBlogNotExistsException")
    void test2() {
        // Arrange
        EntryBlogNotExistsException e = new EntryBlogNotExistsException("mensaje");
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        // Act
        ResponseEntity<?> response = exceptionConfig.entryBlogNotExistsException(e);

        // Assert
        assertEquals(expectedResponse, response);
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
    }
}
