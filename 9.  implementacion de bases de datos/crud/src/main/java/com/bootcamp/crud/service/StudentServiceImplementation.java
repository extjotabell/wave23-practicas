package com.bootcamp.crud.service;

import com.bootcamp.crud.model.Student;
import com.bootcamp.crud.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImplementation implements IStudentService{

    private final IStudentRepository repository;

    public StudentServiceImplementation(IStudentRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, String newName, String newLastname) {
        Student student = repository.findById(id).orElse(null);
        student.setName(newName);
        student.setLastname(newLastname);
        repository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        return repository.findById(id).orElse(null);
    }

}
