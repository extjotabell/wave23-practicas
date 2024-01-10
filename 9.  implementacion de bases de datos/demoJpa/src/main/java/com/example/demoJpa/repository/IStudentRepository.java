package com.example.demoJpa.repository;

import com.example.demoJpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JpaRepository<Student,Long> ---> la clase y el tipo de dato del id
@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
