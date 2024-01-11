package com.meli.crudstudent.service;

import com.meli.crudstudent.model.Student;
import com.meli.crudstudent.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public String saveStudent(Student student) {
        repository.save(student);
        return "El estudiante fue agregado correctamente";
    }

    @Override
    public String deleteStudent(long id) {
        repository.deleteById(id);
        return "El estudiante fue borrado correctamente";
    }

    @Override
    public Student findStudent(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student editStudent(long id, String newName, String newLastname) {
        Student newStudent = this.findStudent(id);
        newStudent.setName(newName);
        newStudent.setLastname(newLastname);

        this.saveStudent(newStudent);
        return newStudent;
    }
}
