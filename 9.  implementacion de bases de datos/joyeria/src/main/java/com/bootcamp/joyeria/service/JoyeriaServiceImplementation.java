package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyeriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyeriaServiceImplementation implements IJoyeriaService{

    private final IJoyeriaRepository repository;

    public JoyeriaServiceImplementation(IJoyeriaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        List<Joya> joyas  = repository.findAll();
        joyas.removeIf(joya -> joya.getVentaONo() == false);
        return joyas;
    }

    @Override
    @Transactional
    public void createJoya(Joya joya) {
        joya.setVentaONo(true);
        repository.save(joya);
    }

    @Override
    @Transactional
    public Joya readJoya(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Joya updateJoya(Long id, String nombre, String material, Double peso, String particularidad, Boolean posee_piedra) {
        Joya joya = repository.findById(id).orElse(null);
        if(!nombre.isEmpty() || nombre != null){
            joya.setNombre(nombre);
        }
        if(!material.isEmpty() || material != null){
            joya.setMaterial(material);
        }
        if(!peso.isNaN() || peso != null){
            joya.setPeso(peso);
        }
        if(!particularidad.isEmpty() || particularidad != null){
            joya.setParticularidad(particularidad);
        }
        if(posee_piedra != null){
            joya.setPosee_piedra(posee_piedra);
        }
        repository.save(joya);
        return joya;
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        joya.setVentaONo(false);
        repository.save(joya);
    }

}
