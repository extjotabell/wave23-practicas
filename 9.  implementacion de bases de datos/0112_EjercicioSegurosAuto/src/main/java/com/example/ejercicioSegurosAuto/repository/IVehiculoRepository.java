package com.example.ejercicioSegurosAuto.repository;

import com.example.ejercicioSegurosAuto.dto.response.VehiculoTotalSiniestrosResponseDto;
import com.example.ejercicioSegurosAuto.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    /*
        Listar las patentes de todos los vehículos registrados.
     */
    @Query("SELECT DISTINCT v FROM Vehiculo v")
    List<Vehiculo> findPatentes();

    /*
        Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
     */
    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findPatentesMarcas();

    /*
        Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan
        sido fabricados en el corriente año.
     */
    @Query("SELECT v FROM Vehiculo v " +
            "WHERE v.cantidadRuedas > 4" +
            "AND v.anioFabricacion = year(current_date())")
    List<Vehiculo> findPatenteByCurrentYear();

    /*
        Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
        con pérdida mayor de 10000 pesos.
    */
    @Query("SELECT DISTINCT " +
            "v " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findSiniestroGreaterThan10000();

    /*
        Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro
        con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de
        todos ellos.
     */
    @Query("SELECT " +
            "NEW com.example.ejercicioSegurosAuto.dto.response.VehiculoTotalSiniestrosResponseDto(" +
            "v.id, v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE v.id IN (" +
            "   SELECT DISTINCT v.id " +
            "   FROM Vehiculo vi " +
            "   JOIN v.siniestros si" +
            "   WHERE si.perdidaEconomica > 10000" +
            ")" +
            "GROUP BY v.id"
    )
    List<VehiculoTotalSiniestrosResponseDto> findTotalMayor10000();

}
