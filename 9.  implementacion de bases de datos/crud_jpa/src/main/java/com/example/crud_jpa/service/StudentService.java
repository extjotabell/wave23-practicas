package com.example.crud_jpa.service;

import com.example.crud_jpa.dto.StudentDTO;
import com.example.crud_jpa.model.Student;
import com.example.crud_jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = convertDTOToEntity(studentDTO);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student editStudent(long id, StudentDTO studentDTO) {
        Student student = findStudentById(id);
        updateStudentFromDTO(student, studentDTO);
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        return findStudentById(id);
    }

    private Student findStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }

    private Student convertDTOToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setLastname(studentDTO.getLastname());
        student.setDni(studentDTO.getDni());
        return student;
    }

    private void updateStudentFromDTO(Student student, StudentDTO studentDTO) {
        student.setName(studentDTO.getName());
        student.setLastname(studentDTO.getLastname());
        student.setDni(studentDTO.getDni());
    }
}
