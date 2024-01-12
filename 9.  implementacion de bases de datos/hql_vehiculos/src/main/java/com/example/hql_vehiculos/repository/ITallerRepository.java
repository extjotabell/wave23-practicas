package com.example.hql_vehiculos.repository;

import com.example.hql_vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ITallerRepository extends JpaRepository<Vehiculo,Integer> {
    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> getAllVehicles();

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatente();

    @Query("SELECT v.patente,v.marca FROM Vehiculo v ORDER BY ano asc")
    List<Object[]> getPatenteMarca();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.ano = :ano AND v.ruedas > 4")
    List<String> getPatentePresentYear(@Param("ano") Integer ano);

    @Query("SELECT v.patente,v.marca,v.modelo FROM Vehiculo v LEFT JOIN " +
            "v.siniestros s WHERE s.perdida >= 10000")
    List<Object[]> getPatenteMarcaModelo();

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdida) FROM Vehiculo v JOIN " +
            "v.siniestros s WHERE s.perdida >= 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> getFinal();
}
