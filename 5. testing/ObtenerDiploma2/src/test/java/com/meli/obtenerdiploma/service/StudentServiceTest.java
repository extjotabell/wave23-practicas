package com.meli.obtenerdiploma.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
public class StudentServiceTest {

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Mock
    StudentRepository studentRepository;

    @Mock
    StudentDAO repository;

    @InjectMocks
    StudentService service;

    @DisplayName("Test de crear a un estudiante (Success)")
    @Test
    public void create(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(100L,"Martin",null,null,subjectDTOList);

        service.create(expected);

        verify(repository,atLeastOnce()).save(expected);
    }

    @DisplayName("Test de leer un alumno (Success)")
    @Test
    public  void read() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT
        Mockito.when(repository.findById(expected.getId())).thenReturn(expected);
        StudentDTO obtain = service.read(expected.getId());

        //ASSERT
        assertEquals(writer.writeValueAsString(expected),writer.writeValueAsString(obtain));

    }

    @DisplayName("Test de actualizar un alumno")
    @Test
    public void update(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT
        service.update(expected);

        //ASSERT
        verify(repository,atLeastOnce()).save(expected);

    }

    @DisplayName("Test de eliminar un alumno")
    @Test
    public void delete(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT
        service.delete(expected.getId());

        //ASSERT
        verify(repository,atLeastOnce()).delete(expected.getId());

    }

    @DisplayName("Test de traer todos los alumnos")
    @Test
    public void getAll() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(test);

        //ACT
        Mockito.when(studentRepository.findAll()).thenReturn(expected);
        Set<StudentDTO> obtain = service.getAll();

        //ASSERT
        assertEquals(writer.writeValueAsString(expected),writer.writeValueAsString(obtain));

    }


}