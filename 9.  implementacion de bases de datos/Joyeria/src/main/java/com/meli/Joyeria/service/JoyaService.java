package com.meli.Joyeria.service;

import com.meli.Joyeria.exception.NotFoundException;
import com.meli.Joyeria.model.Joya;
import com.meli.Joyeria.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Joya save(Joya joya) {
        return repository.save(joya);
    }

    @Override
    public List<Joya> findAll() {
        return repository.findAll().stream()
            .filter(Joya::getVentaONo)
            .toList();
    }

    @Override
    public Joya findById(Long id) {
        return repository.findById(id)
            .filter(Joya::getVentaONo)
            .orElseThrow(() -> new NotFoundException("Joya no encontrada"));
    }

    @Override
    public Joya update(Long id, Joya joya) {
        Joya joyaToUpdate = repository.findById(id)
            .filter(Joya::getVentaONo)
            .orElseThrow(() -> new NotFoundException("Joya no encontrada"));

        joyaToUpdate.setNombre(joya.getNombre());
        joyaToUpdate.setMaterial(joya.getMaterial());
        joyaToUpdate.setPeso(joya.getPeso());
        joyaToUpdate.setParticularidad(joya.getParticularidad());
        joyaToUpdate.setPoseePiedra(joya.getPoseePiedra());

        return repository.save(joyaToUpdate);
    }

    @Override
    public boolean delete(Long id) {
        Joya joyaToDelete = repository.findById(id)
            .filter(Joya::getVentaONo)
            .orElseThrow(() -> new NotFoundException("Joya no encontrada"));

        joyaToDelete.setVentaONo(false);
        repository.save(joyaToDelete);

        return true;
    }
}
