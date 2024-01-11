package com.example.crudJPA.controller;

import com.example.crudJPA.model.Student;
import com.example.crudJPA.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService stuService;

    //Endpoint para crear un nuevo estudiante
    @PostMapping ("/create")
    public String createStudent(@RequestBody Student student) {
        stuService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    //Endpoint para traer a todos los estudiantes
    @GetMapping("/studentes")
    public List<Student>getStudents(){
        List<Student> studentList = stuService.getStudents();
        return studentList;
    }

    //Endpoint para realizar modificaciones a los estudiantes
    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastname") String newLastname) {
        Student stu = stuService.findStudent(id);
        stu.setName(newName);
        stu.setLastname(newLastname);
        stuService.saveStudent(stu);
        return stu;
    }

    //Endpoint para eliminar estudiantes
    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        stuService.deleteStudent(id);
        return "El estudiante fue eliminado correctamente";
    }


}
