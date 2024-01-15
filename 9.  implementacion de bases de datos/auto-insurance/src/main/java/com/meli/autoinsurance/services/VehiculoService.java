package com.meli.autoinsurance.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.autoinsurance.dtos.response.PatenteMarcaDTO;
import com.meli.autoinsurance.dtos.response.VehiculoDTO;
import com.meli.autoinsurance.entities.Vehiculo;
import com.meli.autoinsurance.repositories.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public VehiculoDTO getVehiculoById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehiculo not found for this id  : " + id));
        return mapper.convertValue(vehiculo, VehiculoDTO.class);
    }

    public List<String> getPatentes() {
        return vehiculoRepository.getPatentes();
    }

    public List<PatenteMarcaDTO> getPatenteMarca() {
        List<Object[]> resultadoRepo = vehiculoRepository.getPatenteMarca();
        List<PatenteMarcaDTO> resultado = new ArrayList<>();
        for (Object[] r : resultadoRepo){
            PatenteMarcaDTO patenteMarcaDTO = new PatenteMarcaDTO((String) r[0], (String) r[1]);
            resultado.add(patenteMarcaDTO);
        }
        return resultado;
    }

    public VehiculoDTO createVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.convertValue(vehiculoDTO, Vehiculo.class);
        vehiculoRepository.save(vehiculo);
        return mapper.convertValue(vehiculo, VehiculoDTO.class);
    }

    public List<String> getVehiculoFilterCuatroRuedasAnioActual(){
        return vehiculoRepository.getPatenteByCuatroRuedasAnioDeFabricacionActual();
    }
}
