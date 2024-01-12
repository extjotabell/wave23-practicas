package spring.CRUDJPA.controller;

import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.CRUDJPA.dto.StudentDto;
import spring.CRUDJPA.model.Student;
import spring.CRUDJPA.service.IStudentService;

import java.util.List;

@Validated
@RestController
public class Controller {

    @Autowired
    private IStudentService service;

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentDto student){
        service.saveStudent(student);
        return "El estudiante: " + student.getName() + " fue agregado exitosamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable long id,
                                 @Size(min=1, max=50, message = "El nombre debe contener entre 1 y 50 caracteres") @RequestParam (value = "name", required = false) String newName,
                                 @Size(min=1, max=50, message = "El nombre debe contener entre 1 y 50 caracteres") @RequestParam (value = "lastname", required = false) String newLastname){
        return service.updateStudent(id, newName, newLastname);
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent (@PathVariable long id){
        service.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
