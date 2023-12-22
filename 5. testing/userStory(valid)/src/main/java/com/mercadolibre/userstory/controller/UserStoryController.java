package com.mercadolibre.userstory.controller;

import com.mercadolibre.userstory.dto.request.StudentDTO;
import com.mercadolibre.userstory.service.IStudentService;
import com.mercadolibre.userstory.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStoryController {

    IStudentService studentService;

    public UserStoryController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/userstory")
    public ResponseEntity<?> userStory(@Valid @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.addStudent(studentDTO), HttpStatus.CREATED);
    }
}
