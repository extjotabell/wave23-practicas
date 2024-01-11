package com.practice.clavecompuesta.repository;

import com.practice.clavecompuesta.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Long> {
}
