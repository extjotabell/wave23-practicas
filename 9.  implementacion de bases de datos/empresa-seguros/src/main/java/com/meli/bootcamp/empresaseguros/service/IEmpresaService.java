package com.meli.bootcamp.empresaseguros.service;



import com.meli.bootcamp.empresaseguros.dto.VehiculoDto;

import java.util.List;

public interface IEmpresaService {

    List<?> findByPatente();

    List<?> findByPatenteMarca();

    List<VehiculoDto> findByCurrentYear();

    List<?> findByPMM();

    List<VehiculoDto> findAll();
}
