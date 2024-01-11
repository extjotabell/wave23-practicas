package com.example.estudiante.controller;

import com.example.estudiante.model.Student;
import com.example.estudiante.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public List<Student> getAllStudents(){
        return service.getStudents();
    }

    @PostMapping("edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String lastname){
        Student stu = service.findStudent(id);
        stu.setLastname(lastname);
        stu.setName(newName);
        service.saveStudent(stu);
        return stu;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        service.deleteStudent(id);
        return "El alumno "+id+" fue eliminado";
    }
}
