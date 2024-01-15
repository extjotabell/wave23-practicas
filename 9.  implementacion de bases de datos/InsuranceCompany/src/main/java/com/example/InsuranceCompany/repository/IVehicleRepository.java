package com.example.InsuranceCompany.repository;

import com.example.InsuranceCompany.entity.Vehicle;
import com.example.InsuranceCompany.entity.VehiclePatent;
import com.example.InsuranceCompany.entity.VehiclePatentBrand;
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
    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.yearOfProduction")
    List<VehiclePatent> getPatentByFourWheelsAndManufactureCurrentYear();
}
