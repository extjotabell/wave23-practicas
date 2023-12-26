package com.meli.blogapi.exception;

import com.meli.blogapi.dto.response.ErrorDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExceptionConfigTest {

    @Autowired
    ExceptionConfig exceptionConfig;

    //handlerNotFoundExcepcion(NotFoundException e)
    @Test
    @DisplayName("Handle NotFoundException ")
    void handleNotFounExceptionShouldReturnResponseEntity(){
        //Arrange
        NotFoundException e = new NotFoundException("Test controller advice");
        ResponseEntity<ErrorDTO>  expectedResponse = new ResponseEntity<>(new ErrorDTO("Test controller advice", "ID"),
                                                                            HttpStatus.NOT_FOUND);
        //Act
        ResponseEntity<ErrorDTO> result = exceptionConfig.handlerNotFoundExcepcion(e);

        //Assert
        assertEquals(expectedResponse, result);
    }

    @Test
    @DisplayName("Handle DuplicateIdException ")
    void handleDuplicateIdExceptionShouldReturnResponseEntity(){
        //Arrange
        DuplicateIdException e = new DuplicateIdException("Test controller advice");
        ResponseEntity<ErrorDTO>  expectedResponse = new ResponseEntity<>(new ErrorDTO("Test controller advice", "ID"),
                HttpStatus.BAD_REQUEST);
        //Act
        ResponseEntity<ErrorDTO> result = exceptionConfig.handlerDuplicateIdException(e);

        //Assert
        assertEquals(expectedResponse, result);
    }
}
