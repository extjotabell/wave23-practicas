package com.meli.Vehiculos.repository;

import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import com.meli.Vehiculos.dto.response.VehiculoResponseDTO;
import com.meli.Vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query(
        "SELECT NEW com.meli.Vehiculos.dto.response.VehiculoResponseDTO(v.patente, v.marca) " +
        "FROM Vehiculo v " +
        "ORDER BY v.yearFabricacion"
    )
    List<VehiculoResponseDTO> findAllPatentesAndMarcaOrderByYearFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE (v.cantidadRuedas >= ?1 AND v.yearFabricacion >= ?2)")
    List<String> findAllPatentesByCantidadRuedasAndYearFabricacion(Integer cantidadRuedas, Integer yearFabricacion);

    @Query(
        "SELECT NEW com.meli.Vehiculos.dto.response.VehiculoResponseDTO(v.patente, v.marca, v.modelo) " +
        "FROM Vehiculo v " +
        "JOIN Siniestro s ON s.vehiculo.id = v.id " +
        "WHERE s.perdidaEconomica >= ?1"
    )
    List<VehiculoResponseDTO> findAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(Double perdidaEconomicaSiniestro);

    @Query(
        "SELECT NEW com.meli.Vehiculos.dto.response.VehiculoResponseDTO(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) " +
        "FROM Vehiculo v " +
        "JOIN Siniestro s ON s.vehiculo.id = v.id " +
        "WHERE s.perdidaEconomica >= ?1 " +
        "GROUP BY v.patente, v.marca, v.modelo"
    )
    List<VehiculoResponseDTO> findVehiclesWithTotalLossGreaterThan(Double perdidaEconomicaSiniestro);
}