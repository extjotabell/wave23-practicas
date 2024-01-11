package com.example.estudiante.service;

import com.example.estudiante.model.Student;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    public List<Student> getStudents();

    public String saveStudent(Student stu);

    public String deleteStudent(Long id);

    public Student findStudent(Long id);
    public Student setNameAndLastName (Long id, String newName, String newLastName);
}
