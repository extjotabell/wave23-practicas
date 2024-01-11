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
    public void saveStudent(Student stu) {
        repository.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(Long id) {
        Student stu = repository.findById(id).orElse(null);
        return stu;
    }
}
