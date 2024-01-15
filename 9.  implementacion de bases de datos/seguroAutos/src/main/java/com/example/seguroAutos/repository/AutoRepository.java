package com.example.seguroAutos.repository;

import com.example.seguroAutos.model.Auto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long> {
    @Query("select a.patente from Auto a ")
    List<String> getPatentes();
}
