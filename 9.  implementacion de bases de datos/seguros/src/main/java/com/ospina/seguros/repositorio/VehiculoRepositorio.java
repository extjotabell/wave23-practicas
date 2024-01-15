package com.ospina.seguros.repositorio;

import com.ospina.seguros.modelo.dto.VehiculoResponseMatriculaMarcaModeloDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePatenteMarcaDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePerdidaTotalDto;
import com.ospina.seguros.modelo.entidad.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepositorio extends CrudRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("SELECT new com.ospina.seguros.modelo.dto.VehiculoResponsePatenteMarcaDto(v.patente, v.marca) FROM Vehiculo v WHERE v.anioFabricacion = ?1")
    List<VehiculoResponsePatenteMarcaDto> findByAnioFabricacion(Integer anioFabricacion);

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = FUNCTION('YEAR', CURRENT_DATE)")
    List<String> findPatentesVehiculosConMasDeCuatroRuedasFabricadosEsteAnio();

    @Query("SELECT new com.ospina.seguros.modelo.dto.VehiculoResponseMatriculaMarcaModeloDto(v.patente, v.marca, v.modelo) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<VehiculoResponseMatriculaMarcaModeloDto> findVehiculosConSiniestrosMayorA10000();

    @Query("SELECT new com.ospina.seguros.modelo.dto.VehiculoResponsePerdidaTotalDto(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente,v.marca,v.modelo")
    List<VehiculoResponsePerdidaTotalDto> findVehiculosConSiniestrosMayorA10000YPerdidaTotal();
}