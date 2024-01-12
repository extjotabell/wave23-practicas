package com.meli.Vehiculos.service;

import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import com.meli.Vehiculos.dto.response.VehiculoResponseDTO;
import com.meli.Vehiculos.exception.NotFoundException;
import com.meli.Vehiculos.model.Vehiculo;
import com.meli.Vehiculos.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public List<VehiculoResponseDTO> findAll() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(VehiculoResponseDTO::new).toList();
    }

    @Override
    public VehiculoResponseDTO findById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new NotFoundException("Vehiculo no encontrado"));
        return new VehiculoResponseDTO(vehiculo);
    }

    @Override
    public VehiculoResponseDTO save(VehiculoRequestDTO vehiculoDTO) {
        Vehiculo vehiculoToSave = new Vehiculo(vehiculoDTO);
        Vehiculo vehiculoSaved = vehiculoRepository.save(vehiculoToSave);
        return new VehiculoResponseDTO(vehiculoSaved);
    }

    @Override
    public List<String> findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<VehiculoResponseDTO> findAllPatentesAndMarcaOrderByYearFabricacion() {
        return vehiculoRepository.findAllPatentesAndMarcaOrderByYearFabricacion();
    }

    @Override
    public List<String> findAllPatentesByCantidadRuedasAndYearFabricacion(Integer cantidadRuedas, Integer yearFabricacion) {
        return vehiculoRepository.findAllPatentesByCantidadRuedasAndYearFabricacion(cantidadRuedas, yearFabricacion);
    }

    @Override
    public List<VehiculoResponseDTO> findAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(Double perdidaEconomicaSiniestro) {
        return vehiculoRepository.findAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(perdidaEconomicaSiniestro);
    }

    @Override
    public List<VehiculoResponseDTO> findVehiclesWithTotalLossGreaterThan(Double perdidaEconomicaSiniestro) {
        return vehiculoRepository.findVehiclesWithTotalLossGreaterThan(perdidaEconomicaSiniestro);
    }
}
