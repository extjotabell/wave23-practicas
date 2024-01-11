package com.meli.crudstudent.controller;

import com.meli.crudstudent.model.Student;
import com.meli.crudstudent.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private IStudentService service;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudentes() {
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editStudent(@PathVariable long id,
                                         @RequestParam("name") String newName,
                                         @RequestParam("lastname") String newLastname) {
        return new ResponseEntity<>(service.editStudent(id, newName, newLastname), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id) {
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }
}
