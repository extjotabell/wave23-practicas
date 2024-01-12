package com.example.seguroautos.repository;

import com.example.seguroautos.dto.VehiclePatentDTO;
import com.example.seguroautos.dto.VehiclePatentModelDTO;
import com.example.seguroautos.dto.VehicleSimpleDTO;
import com.example.seguroautos.dto.VehicleSimpleLossDTO;
import com.example.seguroautos.model.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

  @Query("select new com.example.seguroautos.dto.VehiclePatentDTO(vehicle.patent) from Vehicle vehicle")
  List<VehiclePatentDTO> getAllPatents();

  @Query("select new com.example.seguroautos.dto.VehiclePatentModelDTO(vehicle.patent, vehicle.model) from Vehicle vehicle order by vehicle.yearProduction")
  List<VehiclePatentModelDTO> getAllPatentsModelOrderByYearProduction();

  @Query("select new com.example.seguroautos.dto.VehiclePatentDTO(vehicle.patent) from Vehicle vehicle where vehicle.numberWheels>4 and vehicle.yearProduction = YEAR(current_date())")
  List<VehiclePatentDTO> getAllPatentsVehiclesWithNumberWheelsGreater4();

  @Query("select new com.example.seguroautos.dto.VehicleSimpleDTO(vehicle.patent, vehicle.brand, vehicle.model) from Vehicle vehicle inner join vehicle.sinisters sinisters where sinisters.economicLoss >10000")
  List<VehicleSimpleDTO> getAllVehiclesWithSinisterEconomicLossGreaterThan10000();

  @Query("select new com.example.seguroautos.dto.VehicleSimpleLossDTO(vehicle.patent, vehicle.brand, vehicle.model, sum(sinisters.economicLoss)) from Vehicle vehicle inner join vehicle.sinisters sinisters where sinisters.economicLoss >10000 group by sinisters.vehicle")
  List<VehicleSimpleLossDTO> getAllVehiclesWithSinisterEconomicLossGreaterThan10000WithLoss();
}
