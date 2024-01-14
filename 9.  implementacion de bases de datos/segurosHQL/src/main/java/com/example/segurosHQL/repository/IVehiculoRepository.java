package com.example.segurosHQL.repository;

import com.example.segurosHQL.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("FROM Vehiculo v")
    List<Vehiculo> getVehiculos();

    @Query("FROM Vehiculo v ORDER BY v.anioFabricacion ASC")
    List<Vehiculo>getPatentesByAnio();

    @Query("FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = 2024")
    List<Vehiculo>patentesAnioRuedas();

}
