package spring.CRUDJPA.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.CRUDJPA.dto.StudentDto;
import spring.CRUDJPA.model.Student;
import spring.CRUDJPA.repository.IStudentRepository;
import spring.CRUDJPA.util.Mapper;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository repository;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public void saveStudent(StudentDto s) {
        Student student = Mapper.map(s, Student.class);
        repository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Student findStudentById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(long id, String newName, String newLastname) {
        Student updateStudent = findStudentById(id);
        if(newName !=null){
            updateStudent.setName(newName);
        }
        if(newLastname!=null){
            updateStudent.setLastname(newLastname);
        }
        repository.save(updateStudent);
        return updateStudent;
    }
}
