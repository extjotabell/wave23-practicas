package com.mercadolibre.seguro_autos.service;

import com.mercadolibre.seguro_autos.dto.*;

import java.util.List;

public interface IVehicleService {
    List<VehiclePatentDTO> getAllPatents();
    List<VehiclePatentBrandDTO> getPatentsAndBrand();
    List<VehiclePatentDTO> getPatentsFilter();
    List<VehiclePatentBrandModelDTO> getVehiclesWithSinisterFilter();
    List<VehicleWithLostDTO> getSumVehiclesWithSinisterFilter();
}
