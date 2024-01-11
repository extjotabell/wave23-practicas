package com.example.estudiante.service;

import com.example.estudiante.model.Student;
import com.example.estudiante.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository ) {
        this.repository = repository;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = repository.findAll();
        return studentList;
    }

    @Override
    @Transactional
    public String saveStudent(Student stu) {
        repository.save(stu);
        return "El estudiante " +stu.getName() + " fue agregado correctamente.";
    }

    @Override
    @Transactional
    public String deleteStudent(Long id) {
        repository.deleteById(id);
        return "El estudiante de id "+ id +" fue borrado correctamente";
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(Long id) {
        Student stu = repository.findById(id).orElse(null);
        return stu;
    }

    @Override
    public Student setNameAndLastName(Long id, String newName, String newLastName) {
        Student stu = findStudent(id);
        stu.setName(newName);
        stu.setLastname(newLastName);
        saveStudent(stu);
        return stu;
    }
}
