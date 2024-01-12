package com.example.hql_vehiculos.service;

import com.example.hql_vehiculos.model.Vehiculo;
import com.example.hql_vehiculos.repository.ITallerRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Objects;

@Service
public class TallerService {
    private final ITallerRepository repository;


    public TallerService(ITallerRepository repository) {
        this.repository = repository;
    }

    public List<Vehiculo> getAllVehicles(){
        return repository.getAllVehicles();
    }

    public List<String> getAllPatente(){
        return repository.getAllPatente();
    }

    public List<Object[]> getPatenteMarca(){
        return repository.getPatenteMarca();
    }

    public List<String> getPatentePresentYear(){
        return repository.getPatentePresentYear(Year.now().getValue());
    }

    public List<Object[]> getPatenteMarcaModelo(){
        return repository.getPatenteMarcaModelo();
    }

    public List<Object[]> getFinal(){
        return repository.getFinal();
    }
}
