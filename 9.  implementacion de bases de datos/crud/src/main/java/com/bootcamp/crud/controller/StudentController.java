package com.bootcamp.crud.controller;

import com.bootcamp.crud.model.Student;
import com.bootcamp.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService service;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        service.saveStudent(student);
        return "El estudiante fue agregado correctamente.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable long id, @RequestParam("name") String newName, @RequestParam("lastname") String newLastname){
        service.updateStudent(id, newName, newLastname);
        return "El estudiante fue actualizado correctamente.";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        service.deleteStudent(id);
        return "El estudiante fue eliminado correctamente.";
    }

}
