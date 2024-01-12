package com.relations.jpa.repository;

import com.relations.jpa.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManyToManyRepository extends JpaRepository<Student, Long> {

}