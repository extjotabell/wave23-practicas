package com.ejercicio.QATester.repository;

import com.ejercicio.QATester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("FROM TestCase testCase WHERE testCase.lastUpdate >= :date")
    List<TestCase> findTestCasesByDate(LocalDate date);
}
