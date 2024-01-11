package com.example.estudiante.controller;

import com.example.estudiante.model.Student;
import com.example.estudiante.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService service;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        service.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }
}
