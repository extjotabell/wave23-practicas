package com.meli.SeguroAutos.repository;

import com.meli.SeguroAutos.dto.VehicleLossDTO;
import com.meli.SeguroAutos.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select ve.patent from Vehicle ve")
    List<String> findPatentsAllVehicles();

    @Query("select ve.patent, ve.brand from Vehicle ve order by ve.yearOfProduction")
    List<String[]> findPatentsAndBrandForYear();

    @Query("select ve.patent from Vehicle ve where ve.numberOfWheels = 4 and ve.yearOfProduction > current date ")
    List<String> findPatentsWithFourOrMoreWheelsAndManufacturedInTheCurrentYear();

    @Query("select ve.patent, ve.brand, ve.model from Vehicle ve inner join Accident ac on ac.vehicle = ve where ac.economicLosses > 10000")
    List<String[]> findVehiclesWithAccidentMore10000Pesos();

    @Query("select ve.patent, ve.brand, ve.model, sum(ac.economicLosses) from Vehicle ve inner join Accident ac on ac.vehicle = ve where ac.economicLosses > 10000 group by ve.patent, ve.brand, ve.model")
    List<VehicleLossDTO> findVehiclesByMore10000PesosAndTotalEconomicLosses();

}
