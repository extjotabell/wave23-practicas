package com.example.crudJPA.service;

import com.example.crudJPA.model.Student;
import com.example.crudJPA.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository stuRepo;

    public StudentService(IStudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    //READ (para todos los registros) mediante el método findAll()
    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> stuList = stuRepo.findAll();
        return stuList;
    }

    //READ (para un registro en particular) mediante el método findById()
    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }

    //CREATE (dar de alta un registro) mediante el método save()
    @Override
    @Transactional
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    //DELETE (para un registro en particular) mediante el método deleteById()
    @Override
    @Transactional
    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }
}
