package com.example.SeguroAutos.repository;

import com.example.SeguroAutos.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeguroRepository extends JpaRepository<Vehiculo,Integer>{

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> getAllVehicles();

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatente();

    @Query("SELECT v.patente,v.marca FROM Vehiculo v ORDER BY ano asc")
    List<Object[]> getPatenteMarca();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.ano = :ano AND v.ruedas > 4")
    List<String> getPatentePresentYear(@Param("ano") Integer ano);

    @Query("SELECT v.patente,v.marca,v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdida >= 10000")
    List<Object[]> getPatenteMarcaModelo();

}
