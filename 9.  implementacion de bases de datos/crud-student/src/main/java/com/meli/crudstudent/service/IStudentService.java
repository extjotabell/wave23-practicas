package com.meli.crudstudent.service;

import com.meli.crudstudent.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    String saveStudent(Student student);
    String deleteStudent(long id);
    Student findStudent(long id);
    Student editStudent(long id, String newName, String newLastname);
}
