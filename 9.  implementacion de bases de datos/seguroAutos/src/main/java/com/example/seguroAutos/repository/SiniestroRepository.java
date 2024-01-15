package com.example.seguroAutos.repository;

import com.example.seguroAutos.model.Siniestro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends CrudRepository<Siniestro, Long> {
}
