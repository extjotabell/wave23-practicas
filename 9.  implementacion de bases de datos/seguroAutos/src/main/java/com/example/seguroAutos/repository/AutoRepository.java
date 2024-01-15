package com.example.seguroAutos.repository;

import com.example.seguroAutos.model.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long> {
}
