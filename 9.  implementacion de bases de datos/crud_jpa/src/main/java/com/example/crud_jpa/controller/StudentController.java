package com.example.crud_jpa.controller;

import com.example.crud_jpa.dto.StudentDTO;
import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("El estudiante fue agregado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("El estudiante fue borrado correctamente");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable long id, @RequestBody StudentDTO studentUpdateDTO) {
        Student updatedStudent = studentService.editStudent(id, studentUpdateDTO);
        return ResponseEntity.ok(updatedStudent);
    }
}
