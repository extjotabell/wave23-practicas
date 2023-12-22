package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    StudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void registerStudentTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        controller.registerStudent(studentDTO);
        verify(service, atLeastOnce()).create(studentDTO);
    }

    @Test
    public void getStudentTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        when(service.read(1L)).thenReturn(studentDTO);
        StudentDTO result = controller.getStudent(1L);
        assertEquals(studentDTO, result);

    }

    @Test
    public void modifyTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        controller.modifyStudent(studentDTO);
        verify(service, atLeastOnce()).update(studentDTO);

    }
    @Test
    public void removeTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        controller.removeStudent(studentDTO.getId());
        verify(service, atLeastOnce()).delete(studentDTO.getId());

    }
    @Test
    public void listStudentsTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Luis");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",7.0)));

        Set<StudentDTO> studentDTOList = Set.of(studentDTO,studentDTO2);
        when(service.getAll()).thenReturn(studentDTOList);
        Set<StudentDTO> result = controller.listStudents();
        assertEquals(studentDTOList.size(), result.size());

    }
}
