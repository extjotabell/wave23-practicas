package com.mercadolibre.jpacrud.controller;

import com.mercadolibre.jpacrud.model.Student;
import com.mercadolibre.jpacrud.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = studentService.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                              @RequestParam("name") String newName,
                              @RequestParam("lastName") String newLastName) {
    Student student = studentService.findStudent(id);
    student.setName(newName);
    student.setLastName(newLastName);
    studentService.saveStudent(student);
    return student;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
