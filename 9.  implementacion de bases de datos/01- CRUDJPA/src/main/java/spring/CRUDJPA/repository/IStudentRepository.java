package spring.CRUDJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.CRUDJPA.model.Student;
@Repository
public interface IStudentRepository extends JpaRepository <Student, Long> {
}
