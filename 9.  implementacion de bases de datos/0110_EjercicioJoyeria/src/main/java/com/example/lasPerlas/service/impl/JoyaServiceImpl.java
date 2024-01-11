package com.example.lasPerlas.service.impl;

import com.example.lasPerlas.dto.NewJoyaRequestDto;
import com.example.lasPerlas.model.Joya;
import com.example.lasPerlas.repository.JoyaRepository;
import com.example.lasPerlas.service.IJoyaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaServiceImpl(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getAllJoyas() {
        List<Joya> joyaList = joyaRepository.findAll();
        return joyaList.stream().filter(Joya::isVentaONo).toList();
    }

    @Override
    public Joya findOne(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public Joya save(NewJoyaRequestDto joya) {
        Joya newJoya = new Joya();
        newJoya.setNombre(joya.getNombre());
        newJoya.setMaterial(joya.getMaterial());
        newJoya.setPeso(joya.getPeso());
        newJoya.setParticularidad(joya.getParticularidad());
        newJoya.setPoseePiedra(joya.isPoseePiedra());
        newJoya.setVentaONo(joya.isVentaONo());
        return joyaRepository.save(newJoya);
    }

    @Override
    public boolean delete(Long id) {
        Joya found = joyaRepository.findById(id).orElse(null);
        if(found == null) return false;

        found.setVentaONo(false);
        joyaRepository.save(found);
        return true;
    }

    @Override
    public Joya update(Long id, NewJoyaRequestDto updatedJoya) {

        Joya joya = joyaRepository.findById(id).orElse(null);
        if(joya == null) return null;

        joya.setNombre(updatedJoya.getNombre());
        joya.setPeso(updatedJoya.getPeso());
        joya.setMaterial(updatedJoya.getMaterial());
        joya.setParticularidad(updatedJoya.getParticularidad());
        joya.setPoseePiedra(updatedJoya.isPoseePiedra());
        joya.setVentaONo(updatedJoya.isVentaONo());

        return joyaRepository.save(joya);
    }
}
