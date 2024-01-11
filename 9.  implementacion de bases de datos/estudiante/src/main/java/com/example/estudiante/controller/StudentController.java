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

    @GetMapping("/")
    public List<Student> getStudents(){
        List<Student> studentList = service.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam ("name") String newName,
                               @RequestParam ("lastname") String newLastname) {
        Student stu = service.findStudent(id);
        stu.setLastname(newLastname);
        stu.setName(newName);
        service.saveStudent(stu);
        return stu;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        service.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
