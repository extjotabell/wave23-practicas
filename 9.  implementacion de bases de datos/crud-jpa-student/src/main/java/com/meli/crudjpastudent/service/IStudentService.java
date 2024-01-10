package com.meli.crudjpastudent.service;

import com.meli.crudjpastudent.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student student);
    Student updateStudent(long id, String name, String lastname);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}