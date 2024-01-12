package com.example.seguros.repository;

import com.example.seguros.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v.patent FROM Vehicle v")
    List<String> findAllPatents();

    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.yearOfFabrication")
    List<Object[]> findAllPatentsAndBrand();

    @Query("SELECT v FROM Vehicle v WHERE v.wheels > 4 AND YEAR(v.yearOfFabrication) = :currentYear")
    List<Vehicle> findAllByCurrentYear(@Param("currentYear") int currentYear);

    @Query("SELECT a.vehicle FROM Accident a WHERE a.cost > :cost")
    List<Vehicle> findAllByCostGreaterThan(@Param("cost") Double cost);
}
