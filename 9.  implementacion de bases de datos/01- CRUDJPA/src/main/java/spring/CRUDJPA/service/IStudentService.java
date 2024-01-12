package spring.CRUDJPA.service;

import spring.CRUDJPA.dto.StudentDto;
import spring.CRUDJPA.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents();
    void saveStudent(StudentDto s);
    void deleteStudent(long id);
    Student findStudentById(long id);

    Student updateStudent(long id, String newName, String newLastname);
}
