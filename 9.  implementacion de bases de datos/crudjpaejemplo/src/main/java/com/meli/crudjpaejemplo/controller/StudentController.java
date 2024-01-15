package com.meli.crudjpaejemplo.controller;

import com.meli.crudjpaejemplo.dto.ResponseDTO;
import com.meli.crudjpaejemplo.dto.StudentDTO;
import com.meli.crudjpaejemplo.dto.StudentsDTO;
import com.meli.crudjpaejemplo.entity.Student;
import com.meli.crudjpaejemplo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<StudentsDTO> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.findStudent(studentId), HttpStatus.OK);
    }

    @PostMapping("/edit/{studentId}/{name}/{lastName}")
    public ResponseEntity<ResponseDTO> modifyStudent(@PathVariable Long studentId,
                                                    @PathVariable String name,
                                                    @PathVariable String lastName){
        return new ResponseEntity<>(studentService.modifyStudent(studentId, name, lastName), HttpStatus.OK);
    }

    @PostMapping("/delete/{studentId}")
    public ResponseEntity<ResponseDTO> deleteStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }

}
