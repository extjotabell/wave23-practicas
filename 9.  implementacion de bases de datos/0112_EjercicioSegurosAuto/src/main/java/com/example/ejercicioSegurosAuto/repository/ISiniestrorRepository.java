package com.example.ejercicioSegurosAuto.repository;

import com.example.ejercicioSegurosAuto.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestrorRepository extends JpaRepository<Siniestro, Integer> {
}
