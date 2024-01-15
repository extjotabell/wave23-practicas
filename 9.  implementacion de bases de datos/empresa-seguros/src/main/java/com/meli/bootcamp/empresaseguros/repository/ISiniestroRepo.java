package com.meli.bootcamp.empresaseguros.repository;

import com.meli.bootcamp.empresaseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepo extends JpaRepository<Siniestro,Long> {
    @Query("SELECT s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo FROM Siniestro s WHERE s.perdida > 10000")
    List<?> findByPMM();
}
