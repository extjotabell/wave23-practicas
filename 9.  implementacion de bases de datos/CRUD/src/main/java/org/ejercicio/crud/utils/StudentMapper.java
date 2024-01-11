package org.ejercicio.crud.utils;

import org.ejercicio.crud.DTO.StudentDTO;
import org.ejercicio.crud.model.Student;

public class StudentMapper {
    public static StudentDTO studentMap(Student student) {
        return new StudentDTO(student.getId(), student.getDni(), student.getName(), student.getLastname());
    }

    public static Student studentMap(StudentDTO student) {
        return new Student(student.getId(), student.getDni(), student.getName(), student.getLastname());
    }
}
