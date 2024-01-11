package com.mercadolibre.jpacrud.service;

import com.mercadolibre.jpacrud.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}
