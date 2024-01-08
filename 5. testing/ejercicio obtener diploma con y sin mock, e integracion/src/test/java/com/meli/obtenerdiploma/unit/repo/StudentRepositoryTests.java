package com.meli.obtenerdiploma.unit.repo;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

class StudentRepositoryTests {
    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertEquals(students.size(), foundSet.size());
    }
}
