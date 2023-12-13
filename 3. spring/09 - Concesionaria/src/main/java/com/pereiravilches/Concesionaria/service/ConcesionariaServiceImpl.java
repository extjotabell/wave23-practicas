package com.pereiravilches.Concesionaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import com.pereiravilches.Concesionaria.DTO.ResponseDTO;
import com.pereiravilches.Concesionaria.entity.Vehiculo;
import com.pereiravilches.Concesionaria.exception.ErrorAlAgregarVehiculoException;
import com.pereiravilches.Concesionaria.exception.ErrorSolicitudException;
import com.pereiravilches.Concesionaria.exception.VehiculoNoEncontradoException;
import com.pereiravilches.Concesionaria.repository.IConcesionariaRepository;
import lombok.SneakyThrows;
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
    public ResponseDTO agregarVehiculo(RequestVehiculoDTO requestVehiculoDTO) throws ErrorAlAgregarVehiculoException {
        Vehiculo vehiculo = new Vehiculo(requestVehiculoDTO);
        try{
            concesionariaRepository.agregarVehiculo(vehiculo);
            return new ResponseDTO("El vehiculo con id: " + vehiculo.getId() + " fue creado exitosamente. " + "Marca: " + vehiculo.getBrand());
        }catch (Exception e){
            throw new ErrorAlAgregarVehiculoException("Ocurrió un error durante la carga del vehículo");
        }

    }

    @Override
    public RequestVehiculoDTO getVehiculoById(Integer id) throws VehiculoNoEncontradoException {
        Vehiculo respuesta = concesionariaRepository.getVehiculoById(id);
        if(respuesta !=null) {
            return mapper.convertValue(respuesta, RequestVehiculoDTO.class);
        }else {
            throw new VehiculoNoEncontradoException("El vehículo con el id: " + id + " no fue encontrado.");
        }
    }

    @Override
    public List<RequestVehiculoDTO> getUsados() throws ErrorSolicitudException {
        List<Vehiculo> usados = concesionariaRepository.getUsados();
        if(!usados.isEmpty()){
            return convertToDTOResponse(usados);
        }else{
            throw new ErrorSolicitudException("No se pudieron encontrar datos para su solicitud");
        }

    }

    @Override
    public List<RequestVehiculoDTO> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to) throws ErrorSolicitudException {
        List<Vehiculo> vehiculos = concesionariaRepository.getVehiculosPorFechaDeFabricación(since, to);
        if(!vehiculos.isEmpty()){
            return convertToDTOResponse(vehiculos);
        }else{
            throw new ErrorSolicitudException("No se pudieron encontrar datos para su solicitud");
        }
    }

    @Override
    public List<RequestVehiculoDTO> getVehiculosPorPrecio(Integer since, Integer to) throws ErrorSolicitudException {
        List<Vehiculo> vehiculos = concesionariaRepository.getVehiculosPorPrecio(since, to);
        if(!vehiculos.isEmpty()){
            return convertToDTOResponse(vehiculos);
        }else{
            throw new ErrorSolicitudException("No se pudieron encontrar datos para su solicitud");
        }
    }

    private List<RequestVehiculoDTO> convertToDTOResponse(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .map(vehiculo -> mapper.convertValue(vehiculo, RequestVehiculoDTO.class))
                .toList();
    }
}
