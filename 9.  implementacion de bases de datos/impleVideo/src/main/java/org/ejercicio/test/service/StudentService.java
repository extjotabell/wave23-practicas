package org.ejercicio.test.service;

import org.ejercicio.test.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
