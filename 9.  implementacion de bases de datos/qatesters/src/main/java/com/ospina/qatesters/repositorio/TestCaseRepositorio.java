package com.ospina.qatesters.repositorio;

import com.ospina.qatesters.modelo.entidad.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepositorio extends JpaRepository<TestCase, Long> {
}
