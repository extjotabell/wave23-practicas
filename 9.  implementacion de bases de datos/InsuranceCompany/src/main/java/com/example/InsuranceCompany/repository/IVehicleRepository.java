package com.example.InsuranceCompany.repository;

import com.example.InsuranceCompany.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    // List the license plates of all registered vehicles.
    @Query("SELECT v.patent FROM Vehicle v")
    List<VehiclePatent> getAllPatents();

    // List the license plate and brand of all vehicles ordered by year of manufacture.
    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.yearOfProduction")
    List<VehiclePatentBrand> getPatentAndBrandByYearOfManufacture();

    // List the license plate of all vehicles that have more than four wheels and have been manufactured in the current year.
    @Query("SELECT v.patent FROM Vehicle v WHERE v.numberOfWheels >= 4 AND v.yearOfProduction = YEAR(CURRENT_DATE)")
    List<VehiclePatent> getPatentByFourWheelsAndManufactureCurrentYear();

    // List the license plate, brand and model of all vehicles that have had an accident with a loss greater than 10,000 pesos.
    @Query("SELECT v.patent, v.brand, v.model FROM Vehicle v JOIN Sinister s WHERE s.economicLoss > 10000 ORDER BY v.yearOfProduction")
    List<VehiclePatentBrandModel> getPatentBrandModelByAccidentWithLossGreaterThan10000();

    // List the license plate, make and model of all vehicles that have had an accident with a loss greater than 10,000 pesos and show how much the total loss was for all of them.
    @Query("SELECT v.patent, v.brand, v.model, SUM(s.economicLoss) " +
            " FROM Vehicle v JOIN Sinister s " +
            " WHERE s.economicLoss > 10000 " +
            " GROUP BY v.patent, v.brand, v.model")
    List<VehiclePatentBrandLoss> getVehicleDetailsWithTotalLossGreaterThan10000();
}
