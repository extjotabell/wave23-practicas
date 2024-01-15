package org.bootcamp.hqlvehiculo.repository;

import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelTotalCostDTO;
import org.bootcamp.hqlvehiculo.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT V.licencePlate " +
            "FROM Vehicle AS V")
    List<String> getLicencePlates();

    @Query("SELECT V.licencePlate, V.brand " +
            "FROM Vehicle AS V " +
            "WHERE V.year = :year " +
            "ORDER BY V.year ASC")
    List<VehicleLicenceBrandDTO> getLicenceBrandByYear(@Param("year") Integer year);

    @Query(value = "SELECT V.licencePlate " +
            "FROM Vehicle AS V " +
            "WHERE V.wheels > 4 AND v.year = YEAR(CURRENT_DATE)", nativeQuery = true)
    List<String> getLicencePlateMoreThanFourWheelsFromCurrentYear();

    @Query("SELECT V.licencePlate, V.brand, V.model " +
            "FROM Vehicle AS V " +
            "INNER JOIN Accident AS A ON V.id = A.id " +
            "WHERE A.economicCost > 10000")
    List<VehicleLicenceBrandModelDTO> getLicenceBrandModelFromAccidentsMoreThan10000Costs();

    @Query("SELECT V.licencePlate, V.brand, V.model, SUM(A.economicCost) " +
            "FROM Vehicle AS V " +
            "INNER JOIN Accident AS A ON V.id = A.vehicle.id " +
            "WHERE A.economicCost > 10000 " +
            "GROUP BY V.licencePlate, V.brand, V.model")
    List<VehicleLicenceBrandModelTotalCostDTO> getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost();

}
