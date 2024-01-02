package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.exception.ExceptionController;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class HandlerTest {
    @Autowired
    ExceptionController exceptionController;

    @Test
    void notFoundTestOK(){
        //Arrange
        NotFoundException exception = new NotFoundException("mensaje");
        ResponseEntity<?> expectResponse = new ResponseEntity<>(new ExceptionDto("mensaje"), HttpStatus.NOT_FOUND);
        //Act
        ResponseEntity<?> response = exceptionController.notFound(exception);
        //Assert
        Assertions.assertEquals(expectResponse,response);
    }
}
