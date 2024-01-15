package com.meli.autoinsurance.repositories;

import com.meli.autoinsurance.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT V.patente FROM vehiculos V")
    List<String> getPatentes();
}