package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JoyeriaService implements IService {

    @Autowired
    IJoyeriaRepository repository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Long createJoya(JoyaDTO joyaDTO) {
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        repository.save(joya);
        return joya.getNro_identificatorio();
    }

    @Override
    public List<JoyaDTO> getJoyas() {
        List<Joya> joyas = repository.findAllByPoseeVentaTrue();
        return joyas.stream().map(joya -> mapper.convertValue(joya, JoyaDTO.class)).toList();
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        if (joya == null){
            throw new RuntimeException("Usuario no encontrado");
        }
        joya.setPoseeVenta(false);
        repository.save(joya);
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Joya searchedJoya = repository.findById(id).orElse(null);
        if (searchedJoya == null){
            throw new RuntimeException("Usuario no encontrado");
        }
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        joya.setNro_identificatorio(id);
        repository.save(joya);
        return mapper.convertValue(joya, JoyaDTO.class);

    }
}
