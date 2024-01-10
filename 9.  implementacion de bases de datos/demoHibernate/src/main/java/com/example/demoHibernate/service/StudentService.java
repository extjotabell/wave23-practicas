package com.example.demoHibernate.service;

import com.example.demoHibernate.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }
}
