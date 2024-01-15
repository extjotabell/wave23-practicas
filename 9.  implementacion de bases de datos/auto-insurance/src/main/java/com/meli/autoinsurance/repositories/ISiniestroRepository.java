package com.meli.autoinsurance.repositories;

import com.meli.autoinsurance.entities.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT S.vehiculoDenunciado.patente, S.vehiculoDenunciado.marca, S.vehiculoDenunciado.modelo FROM siniestros S WHERE S.perdidaEconomica > 10000")
    List<Object []> getMatriculaMarcaModeloByPerdidaGreaterThan10K();
}