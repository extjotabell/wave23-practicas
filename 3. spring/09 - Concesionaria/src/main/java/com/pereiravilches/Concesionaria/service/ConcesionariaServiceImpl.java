package com.pereiravilches.Concesionaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import com.pereiravilches.Concesionaria.DTO.ResponseDTO;
import com.pereiravilches.Concesionaria.entity.Vehiculo;
import com.pereiravilches.Concesionaria.repository.IConcesionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConcesionariaServiceImpl implements IConcesionariaService{

    @Autowired
    IConcesionariaRepository concesionariaRepository;
    ObjectMapper mapper;

    public ConcesionariaServiceImpl() {
        this. mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public ResponseDTO agregarVehiculo(RequestVehiculoDTO requestVehiculoDTO) {
        Vehiculo vehiculo = new Vehiculo(requestVehiculoDTO);
        concesionariaRepository.agregarVehiculo(vehiculo);
        return new ResponseDTO("El vehiculo con id: " + vehiculo.getId() + " fue creado exitosamente. " + "Marca: " + vehiculo.getBrand());
    }

    @Override
    public RequestVehiculoDTO getVehiculoById(Integer id) {
        Vehiculo respuesta = concesionariaRepository.getVehiculoById(id);
        return mapper.convertValue(respuesta, RequestVehiculoDTO.class);
    }

    @Override
    public List<RequestVehiculoDTO> getUsados() {
        List<Vehiculo> usados = concesionariaRepository.getUsados();
        return convertToDTOResponse(usados);
    }

    @Override
    public List<RequestVehiculoDTO> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to) {
        List<Vehiculo> vehiculos = concesionariaRepository.getVehiculosPorFechaDeFabricación(since, to);
        return convertToDTOResponse(vehiculos);
    }

    @Override
    public List<RequestVehiculoDTO> getVehiculosPorPrecio(Integer since, Integer to) {
        List<Vehiculo> vehiculos = concesionariaRepository.getVehiculosPorPrecio(since, to);
        return convertToDTOResponse(vehiculos);
    }

    private List<RequestVehiculoDTO> convertToDTOResponse(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, RequestVehiculoDTO.class))
                .toList();
    }
}
