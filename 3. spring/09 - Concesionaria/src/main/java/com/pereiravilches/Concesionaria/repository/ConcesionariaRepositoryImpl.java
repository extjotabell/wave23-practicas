package com.pereiravilches.Concesionaria.repository;

import com.pereiravilches.Concesionaria.entity.Service;
import com.pereiravilches.Concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ConcesionariaRepositoryImpl implements IConcesionariaRepository{
    List<Vehiculo> vehiculoList = new ArrayList<>();

    public ConcesionariaRepositoryImpl() {
        cargarAutos();
    }
    @Override
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }

    @Override
    public Vehiculo getVehiculoById(Integer id) {
        try{
            return vehiculoList.stream()
                    .filter(vehiculo -> vehiculo.getId().equals(id))
                    .findFirst().get();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Vehiculo> getUsados() {
        LocalDate fechaReferencia = LocalDate.of(2023,12,12);
        return vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getManufacturingDate().isBefore(fechaReferencia))
                .toList();
    }

    @Override
    public List<Vehiculo> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to) {
        return vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getManufacturingDate().isAfter(since) && vehiculo.getManufacturingDate().isBefore(to))
                .toList();
    }

    @Override
    public List<Vehiculo> getVehiculosPorPrecio(Integer since, Integer to) {
        return vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getPrice() >= since && vehiculo.getPrice() <= to)
                .toList();
    }

    private void cargarAutos() {
        vehiculoList.add(new Vehiculo(1, "Ford", "Focus", LocalDate.of(2023,12,01), "0", "5", 10000, "USD", List.of(new Service(LocalDate.of(2023,12,01), "0", "Primer service")),"1"));
        vehiculoList.add(new Vehiculo(2, "Toyota", "Corolla", LocalDate.of(2023,12,01), "0", "5", 15000, "USD", List.of(new Service(LocalDate.of(2023,12,01), "0", "Primer service")),"1"));
        vehiculoList.add(new Vehiculo(3, "Peugeot", "208", LocalDate.of(2023,12,01), "0", "5", 20000, "USD", List.of(new Service(LocalDate.of(2023,12,01), "0", "Primer service")),"1"));
    }
}

