package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
   @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService service;

    @Test
    public void createCalledTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        service.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void readOkTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = service.read(1L);
        assertEquals(studentDTO,result);
    }

    @Test
    public void updateCalledTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        service.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void deleteCalledTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        service.delete(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void getAllTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Luis");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",7.0)));

        Set<StudentDTO> studentDTOList = Set.of(studentDTO,studentDTO2);
        when(studentRepository.findAll()).thenReturn(studentDTOList);
        Set<StudentDTO> result = service.getAll();
        assertEquals(studentDTOList.size(),result.size());
    }
}
