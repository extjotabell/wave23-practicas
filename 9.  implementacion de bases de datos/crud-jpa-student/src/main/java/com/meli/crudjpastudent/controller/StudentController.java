package com.meli.crudjpastudent.controller;

import com.meli.crudjpastudent.model.Student;
import com.meli.crudjpastudent.service.IStudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable long id, @RequestParam("name") String newName, @RequestParam("lastname") String newLastname){
        return new ResponseEntity<>(studentService.updateStudent(id, newName, newLastname), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

}
