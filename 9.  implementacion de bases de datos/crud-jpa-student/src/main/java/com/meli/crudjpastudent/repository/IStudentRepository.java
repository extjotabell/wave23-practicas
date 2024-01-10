package com.meli.crudjpastudent.repository;

import com.meli.crudjpastudent.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}