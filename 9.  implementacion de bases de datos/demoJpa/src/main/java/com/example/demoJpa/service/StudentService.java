package com.example.demoJpa.service;

import com.example.demoJpa.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }
}
