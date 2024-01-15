package com.mercadolibre.seguro_autos.repository;

import com.mercadolibre.seguro_autos.dto.VehiclePatentBrandDTO;
import com.mercadolibre.seguro_autos.dto.VehiclePatentBrandModelDTO;
import com.mercadolibre.seguro_autos.dto.VehiclePatentDTO;
import com.mercadolibre.seguro_autos.dto.VehicleWithLostDTO;
import com.mercadolibre.seguro_autos.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT v.patent FROM Vehicle v")
    List<VehiclePatentDTO> getAllPatents();

    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.yearProduction")
    List<VehiclePatentBrandDTO> getPatentsAndBrand();

    @Query("SELECT v.patent FROM Vehicle v WHERE v.numberWheels > 4 AND v.yearProduction = YEAR(CURRENT_DATE)")
    List<VehiclePatentDTO> getPatentsFilter();

    @Query("SELECT v.patent, v.brand, v.model FROM Vehicle v INNER JOIN Sinister s ON v.id = s.vehicle.id WHERE s.economicLoss > 10000")
    List<VehiclePatentBrandModelDTO> getVehiclesWithSinisterFilter();

    @Query("SELECT SUM(s.economicLoss) FROM Vehicle v INNER JOIN Sinister s ON v.id = s.vehicle.id WHERE s.economicLoss > 10000 GROUP BY s.vehicle")
    List<VehicleWithLostDTO> getSumVehiclesWithSinisterFilter();
}
