package com.meli.crudjpaejemplo.service;

import com.meli.crudjpaejemplo.dto.ResponseDTO;
import com.meli.crudjpaejemplo.dto.StudentDTO;
import com.meli.crudjpaejemplo.dto.StudentsDTO;
import com.meli.crudjpaejemplo.entity.Student;

import java.util.List;

public interface StudentService {

    StudentsDTO getStudents();
    ResponseDTO saveStudent(Student student);
    ResponseDTO modifyStudent(Long id, String name, String lastName);
    ResponseDTO deleteStudent(Long id);
    StudentDTO findStudent(Long id);
}
