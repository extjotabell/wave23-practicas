package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;

//No mockito :c
public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("StudentDAO - save: verificar que el estudiante sea correctamente almacenado cuando no existe.")
    public void createNonExistenStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        studentDAO.save(stu);
        // Assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    @DisplayName("StudentDAO - save: Verificar que el método es correcto en save")
    public void modifyNonExistentStudent() {
        // Arrange
        StudentDTO stu1 = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        stu2.setId(999L);
        stu2.setStudentName("Fernando Meza");
        studentDAO.save(stu1);
        // Act
        studentDAO.save(stu2);
        // Assert
        Assertions.assertTrue(studentDAO.exists(stu1));
        Assertions.assertEquals(1L, stu1.getId());
        Assertions.assertEquals(studentDAO.findById(stu1.getId()), stu1);

        Assertions.assertTrue(studentDAO.exists(stu2));
        Assertions.assertEquals(2L, stu2.getId());
        Assertions.assertEquals(studentDAO.findById(stu2.getId()), stu2);

    }

    @Test
    @DisplayName("StudentDAO - save: Verificar que el estudiante fue modificado")
    public void modifyExistentStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        studentDAO.save(stu);
        // Act
        stu.setStudentName("Fernando Polo");
        studentDAO.save(stu);

        // Assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    @DisplayName("StudentDAO - findById: Verificar que el estudiante si haya sido localizado.")
    public void findExistentStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        studentDAO.save(stu);
        // Act
        StudentDTO found = studentDAO.findById(stu.getId());
        // Assert
        Assertions.assertEquals(found, stu);
    }

    @Test
    @DisplayName("StudentDAO - findById: " +
            "Verificar que la excepcion StuddentNotFoundException sea lanzada al no existir el estudiante.")
    public void finNonExistenStudent(){
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stu.getId()));
    }

    @Test
    @DisplayName("StudentDAO - delete: " +
            "Verificar que la excepcion StuddentNotFoundException sea lanzada al no existir el estudiante.")
    public void deleteNonExistenStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        studentDAO.save(stu);
        // Act
        studentDAO.delete(stu.getId());
        // Assert
        Assertions.assertFalse(studentDAO.exists(stu));
    }


}
