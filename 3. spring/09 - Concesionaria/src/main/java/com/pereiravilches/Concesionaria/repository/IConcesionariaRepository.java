package com.pereiravilches.Concesionaria.repository;

import com.pereiravilches.Concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaRepository {
    void agregarVehiculo(Vehiculo vehiculo);
    Vehiculo getVehiculoById(Integer id);

    List<Vehiculo> getUsados();

    List<Vehiculo> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to);
    List<Vehiculo> getVehiculosPorPrecio(Integer since, Integer to);
}
