package com.example.compraclavecompuesta.repository;

import com.example.compraclavecompuesta.model.Compra;
import com.example.compraclavecompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {

}
