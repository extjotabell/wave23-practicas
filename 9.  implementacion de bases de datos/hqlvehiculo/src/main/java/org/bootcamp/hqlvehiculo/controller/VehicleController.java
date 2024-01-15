package org.bootcamp.hqlvehiculo.controller;

import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelTotalCostDTO;
import org.bootcamp.hqlvehiculo.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private IVehicleService service;

    @GetMapping("/getlicenceplates")
    public List<String> getLicencePlates(){
        return service.getLicencePlates();
    }

    @GetMapping("/getlicenceplates/{year}")
    public List<VehicleLicenceBrandDTO> getLicenceBrandByYear(@PathVariable Integer year){
        return service.getLicenceBrandByYear(year);
    }

    /*
    @GetMapping("/getlicenceplates/four-wheels/current-year")
    public List<String> getLicencePlateMoreThanFourWheelsFromCurrentYear(){
        return service.getLicencePlateMoreThanFourWheelsFromCurrentYear();
    }
     */

    @GetMapping("/getlicenceplates/accidents-costs")
    public List<VehicleLicenceBrandModelDTO> getLicenceBrandModelFromAccidentsMoreThan10000Costs(){
        return service.getLicenceBrandModelFromAccidentsMoreThan10000Costs();
    }

    @GetMapping("/getlicenceplates/accidents-costs/total")
    public List<VehicleLicenceBrandModelTotalCostDTO> getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost(){
        return service.getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost();
    }

}
