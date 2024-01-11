package com.example.ejercicioClaveCompuesta.repository;

import com.example.ejercicioClaveCompuesta.model.Compra;
import com.example.ejercicioClaveCompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
