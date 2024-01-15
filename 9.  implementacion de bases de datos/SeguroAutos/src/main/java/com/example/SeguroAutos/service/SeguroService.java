package com.example.SeguroAutos.service;

import com.example.SeguroAutos.model.entity.Vehiculo;
import com.example.SeguroAutos.repository.ISeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Year;
import java.util.List;

public class SeguroService {

    @Autowired
    ISeguroRepository repository;

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
}
