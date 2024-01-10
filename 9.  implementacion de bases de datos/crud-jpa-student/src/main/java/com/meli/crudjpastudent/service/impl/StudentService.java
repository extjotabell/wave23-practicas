package com.meli.crudjpastudent.service.impl;

import com.meli.crudjpastudent.model.Student;
import com.meli.crudjpastudent.repository.IStudentRepository;
import com.meli.crudjpastudent.service.IStudentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService  implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(long id, String name, String lastname){
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(name);
        student.setLastName(lastname);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
