package com.meli.ejercicioSiniestros.repository;

import com.meli.ejercicioSiniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllVehiculos();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v")
    List<String[]> getPatenteYMarcaFromVehiculo();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas>4 AND v.anoFabricacion = YEAR(CURRENT_DATE)")
    List<String[]> getAllVehiculosWithMoreThanFourWheelsAndFabricatedThisYear();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdida > 10000")
    List<String[]> getVehiculosWithSiniestroCostingMoreThanTenThousand();
}
