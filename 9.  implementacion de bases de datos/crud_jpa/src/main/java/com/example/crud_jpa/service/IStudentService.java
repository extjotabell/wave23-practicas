package com.example.crud_jpa.service;

import com.example.crud_jpa.dto.StudentDTO;
import com.example.crud_jpa.model.Student;
import java.util.List;

public interface IStudentService {

    List<Student> getStudents ();
    void saveStudent(StudentDTO studentDTO);
    void deleteStudent (long id);
    Student findStudent (long id);
    Student editStudent(long id, StudentDTO studentUpdateDTO);

}
