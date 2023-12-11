package com.meli.autos.dto.request;


import com.meli.autos.dto.response.ServiceDTO;
import com.meli.autos.dto.response.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntryDTO extends VehicleDTO {
    private List<ServiceDTO> services;
}
