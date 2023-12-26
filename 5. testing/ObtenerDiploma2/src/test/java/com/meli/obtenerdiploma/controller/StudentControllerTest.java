package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Mock
    StudentService service;

    @InjectMocks
    StudentController controller;

    @DisplayName("Test de register student")
    @Test
    public void registerStudent(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT && ASSERT
        controller.registerStudent(test);
        verify(service,atLeastOnce()).create(test);

    }

    @DisplayName("Test de getStudent student")
    @Test
    public void getStudent() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT

        Mockito.when(service.read(test.getId())).thenReturn(test);

        StudentDTO obtain = controller.getStudent(test.getId());

        //ASSERT

        verify(service,atLeastOnce()).read(test.getId());
        assertEquals(writer.writeValueAsString(test),writer.writeValueAsString(obtain));

    }

    @DisplayName("Test de modifyStudent student")
    @Test
    public void modifyStudent() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT && ASSERT

        controller.modifyStudent(test);
        verify(service,atLeastOnce()).update(test);
    }

    @DisplayName("Test de modifyStudent student")
    @Test
    public void removeStudent() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT && ASSERT
        controller.removeStudent(test.getId());
        verify(service,atLeastOnce()).delete(test.getId());
    }

    @DisplayName("Test de modifyStudent student")
    @Test
    public void listStudent() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(test);

        //ACT
        Mockito.when(service.getAll()).thenReturn(expected);
        Set<StudentDTO> obtain = controller.listStudents();

        //ASSERT
        assertEquals(writer.writeValueAsString(expected),writer.writeValueAsString(obtain));
    }
}
