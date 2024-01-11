package org.ejercicio.crud.service;

import org.ejercicio.crud.DTO.response.SimpleMessageDTO;
import org.ejercicio.crud.DTO.StudentDTO;
import org.ejercicio.crud.model.Student;
import org.ejercicio.crud.repository.IStudentRepository;
import org.ejercicio.crud.utils.StudentMapper;
import org.ejercicio.crud.utils.Verification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository repository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = repository.findAll();
        return students.stream().map(StudentMapper::studentMap).toList();
    }

    @Override
    public SimpleMessageDTO saveStudent(StudentDTO student) {
        repository.save(StudentMapper.studentMap(student));
        return new SimpleMessageDTO("El usuario " + student.getName() + " fué agregado con éxito.");
    }

    @Override
    public SimpleMessageDTO deleteStudent(Long id) {
        Student student = repository.findById(id).orElse(null);
        Verification.studentExists(student, id);
        repository.deleteById(id);
        return new SimpleMessageDTO("El usuario con id " + id + " fué eliminado con éxito.");

    }

    @Override
    public StudentDTO findStudent(Long id) {
        Student student = repository.findById(id).orElse(null);
        Verification.studentExists(student, id);
        return StudentMapper.studentMap(student);
    }

    @Override
    public StudentDTO editStudent(Long id, String newName, String newLastName) {
        Student student = repository.findById(id).orElse(null);
        Verification.studentExists(student, id);
        student.setName(newName);
        student.setLastname(newLastName);
        repository.save(student);
        return StudentMapper.studentMap(student);
    }
}
