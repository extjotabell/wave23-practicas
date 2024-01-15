package com.mercadolibre.companyautoinsurance.repositories;

import com.mercadolibre.companyautoinsurance.models.entities.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT vehicles.patentVehicles FROM Vehicle vehicles")
    List<String> findAllRegisteredVehiclesPatents();

    @Query("SELECT vvehicles.patentVehicles, vvehicles.brandVehicles FROM Vehicle vvehicles ORDER BY vvehicles.yearBuildVehicles")
    List<Object[]> findAllPatentAndBrandVehiclesOrderByYearFabrication();

    @Query("SELECT vehicles.patentVehicles FROM Vehicle vehicles" +
            " WHERE vehicles.quantityWheelsVehicles > 4 AND vehicles.yearBuildVehicles = YEAR(CURRENT_DATE)")
    List<String> findAllVehiclesWithMoreThanFourWheelsAndManufacturedThisYear();

    @Query("SELECT vehicles.patentVehicles, vehicles.brandVehicles, vehicles.modelVehicles FROM Vehicle vehicles " +
            "JOIN vehicles.accidents accidents WHERE accidents.economicLoss > 10000")
    List<Object[]> findAllVehiclesWithAccidentsWithLossGreaterThan10000();

    @Query("SELECT vehicles, SUM(accidents.economicLoss) " +
            "FROM Vehicle vehicles JOIN vehicles.accidents accidents WHERE accidents.economicLoss > 10000 GROUP BY vehicles")
    List<Object[]> findAllVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss();
}
