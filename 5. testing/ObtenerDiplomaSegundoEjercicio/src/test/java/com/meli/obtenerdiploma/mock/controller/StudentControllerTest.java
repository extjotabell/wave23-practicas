package com.meli.obtenerdiploma.mock.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    StudentDTO stu;
    StudentDTO stu2;
    StudentDTO stu3;

    @BeforeEach
    void initialize(){
        stu = new StudentDTO(1L,
                "Nico",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }});

        stu2 = new StudentDTO(1L,
                "Abril",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }});

        stu3 =  new StudentDTO(1L,
                "Marco",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }});
    }

    @Test
    public void registerStudent() {

        controller.registerStudent(stu);


        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent() {

        when(service.read(stu.getId())).thenReturn(stu);

        StudentDTO readStu = controller.getStudent(stu.getId());

        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {

        controller.modifyStudent(stu);

        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {

        controller.removeStudent(stu.getId());

        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        Set<StudentDTO> students = new HashSet<>(){{add(stu);add(stu2);add(stu3);}};
        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> readStudents = controller.listStudents();

        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
