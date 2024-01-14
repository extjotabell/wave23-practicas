package com.example.demo.service;

import com.example.demo.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository repository;

    public StudentService (IStudentRepository repository){
        this.repository = repository;
    }
}
