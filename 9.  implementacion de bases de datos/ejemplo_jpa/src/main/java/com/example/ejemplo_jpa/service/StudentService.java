package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository iStudentRepository;

    public StudentService (IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return iStudentRepository.findAll();
    }

    @Override
    public void saveStudent(Student stu) {
        iStudentRepository.save(stu);
    }

    @Override
    public void deleteStudent(long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(long id) {
        return iStudentRepository.findById(id).orElse(null);
    }
}
