package org.ejercicio.surehql.repository;

import org.ejercicio.surehql.model.dto.BrandDTO;
import org.ejercicio.surehql.model.dto.PatentDTO;
import org.ejercicio.surehql.model.dto.VehicleDTO;
import org.ejercicio.surehql.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public interface ISureRespository extends JpaRepository<Vehicle, Long> {

    @Query("FROM Vehicle v")
    List<Vehicle> getPatents();

    @Query("FROM Vehicle v " +
            "ORDER BY v.yearOfProduction")
    List<Vehicle> getPatentsAndBrand();

    @Query("FROM Vehicle v " +
            "WHERE v.wheels > 4 " +
            "AND v.yearOfProduction BETWEEN :startDate AND :endDate")
    List<Vehicle> getPatentsFilter(LocalDate startDate, LocalDate endDate);

    @Query("FROM Vehicle v " +
            "JOIN Sinester s ON v.id = s.vehicle.id " +
            "WHERE s.amount > 10000")
    List<Vehicle> getModelFilteredSinister();

    @Query("SELECT SUM(s.amount) FROM Sinester s")
    Double getTotalLostSinister();
}
