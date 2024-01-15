package com.meli.bootcamp.empresaseguros.repository;

import com.meli.bootcamp.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepo extends JpaRepository<Vehiculo,Long> {


    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findByPatente();
    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.fechaFabricacion")
    List<?> findByPatenteMarca();
    @Query("FROM Vehiculo v WHERE v.ruedas > 4 AND YEAR(v.fechaFabricacion) = :currentYear")
    List<Vehiculo> findByCurrentYear(@Param("currentYear") int currentYear);



}
