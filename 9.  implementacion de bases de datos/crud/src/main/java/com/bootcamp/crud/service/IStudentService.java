package com.bootcamp.crud.service;

import com.bootcamp.crud.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents();

    void saveStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Long id, String newName, String newLastname);

    Student findStudent(Long id);

}
