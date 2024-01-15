package com.meli.autoinsurance.repositories;

import com.meli.autoinsurance.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    //Listar patentes
    @Query("SELECT V.patente FROM vehiculos V")
    List<String> getPatentes();
    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricacion.
    @Query("SELECT V.patente, V.marca FROM vehiculos V ORDER BY V.anioDeFabricacion")
    List<Object []> getPatenteMarca();
    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT V.patente FROM vehiculos V WHERE V.cantidadDeRuedas > 4 AND V.anioDeFabricacion = year(current_date())")
    List<String> getPatenteByCuatroRuedasAnioDeFabricacionActual();
}