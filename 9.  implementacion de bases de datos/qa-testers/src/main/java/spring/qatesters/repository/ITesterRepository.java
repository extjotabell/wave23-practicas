package spring.qatesters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.qatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITesterRepository extends JpaRepository <TestCase, Long> {
    List<TestCase> findAllByLastUpdateIsAfter(Optional<LocalDate> date);
}
