package org.ejercicio.crud.service;


import org.ejercicio.crud.DTO.response.SimpleMessageDTO;
import org.ejercicio.crud.DTO.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getStudents();

    SimpleMessageDTO saveStudent(StudentDTO stu);

    SimpleMessageDTO deleteStudent(Long id);

    StudentDTO findStudent(Long id);

    StudentDTO editStudent(Long id, String newName, String newLastName);
}
