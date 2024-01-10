package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.service.IStudentService;
import com.example.ejemplo_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping ("/create")
    public String createStudent(@RequestBody Student student) {
        iStudentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping ("/students")
    public List<Student> getStudentList () {
        return iStudentService.getStudents();
    }

    @PostMapping ("edit/{id}")
    public Student editStudent (@PathVariable long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastName) {
        Student stu = iStudentService.findStudent(id);
        // Esto deberìa de ir en el service
        stu.setLastname(newName);
        stu.setName(newLastName);
        iStudentService.saveStudent(stu);
        return stu;
    }

    @PostMapping("delete/{id}")
        public String deleteStudent (@PathVariable long id) {
            iStudentService.deleteStudent(id);
            return "El estudiante fue borrado correctamente";
        }

}
