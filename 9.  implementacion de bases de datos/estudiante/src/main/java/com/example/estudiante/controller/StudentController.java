package com.example.estudiante.controller;

import com.example.estudiante.model.Student;
import com.example.estudiante.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping()
    public List<Student> getStudents (){
        return service.getStudents();
    }

    @PostMapping("edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam("name") String newName,
                                @RequestParam ("lastname") String newLastName) {
        return service.setNameAndLastName(id,newName,newLastName);
    }

    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        return service.deleteStudent(id);
    }
}
