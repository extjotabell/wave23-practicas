package com.meli.crudjpaejemplo.util.mapper;

import com.meli.crudjpaejemplo.dto.StudentDTO;
import com.meli.crudjpaejemplo.dto.StudentsDTO;
import com.meli.crudjpaejemplo.entity.Student;

import java.util.List;

public class StudentMapper {
    public static StudentsDTO mapToStudentsDTO(List<Student> studentList){
        return new StudentsDTO(studentList.stream().map(StudentMapper::mapToStudentDTO).toList());
    }

    public static StudentDTO mapToStudentDTO(Student student){
        return new StudentDTO(student.getDni(), student.getName(), student.getLastName());
    }
}
