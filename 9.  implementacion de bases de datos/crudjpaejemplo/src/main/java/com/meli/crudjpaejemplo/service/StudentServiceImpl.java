package com.meli.crudjpaejemplo.service;

import com.meli.crudjpaejemplo.dto.ResponseDTO;
import com.meli.crudjpaejemplo.dto.StudentDTO;
import com.meli.crudjpaejemplo.dto.StudentsDTO;
import com.meli.crudjpaejemplo.entity.Student;
import com.meli.crudjpaejemplo.repository.StudentRepository;
import com.meli.crudjpaejemplo.util.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional (readOnly = true)
    public StudentsDTO getStudents() {
        return StudentMapper.mapToStudentsDTO(studentRepository.findAll());
    }

    @Override
    @Transactional
    public ResponseDTO saveStudent(Student student) {
        studentRepository.save(student);
        return new ResponseDTO("The student has been successfully saved.");
    }

    @Override
    public ResponseDTO modifyStudent(Long id, String name, String lastName){
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(name);
        student.setLastName(lastName);
        studentRepository.save(student);
        return new ResponseDTO("The student has been successfully updated.");
    }

    @Override
    @Transactional
    public ResponseDTO deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return new ResponseDTO("The student has been successfully deleted.");
    }

    @Override
    @Transactional (readOnly = true)
    public StudentDTO findStudent(Long id) {
        return StudentMapper.mapToStudentDTO(studentRepository.findById(id).orElse(null));
    }
}
