package com.meli.joyeria.service;

import com.meli.joyeria.dto.request.JoyaCreationDTO;
import com.meli.joyeria.dto.response.JoyaCompletaDTO;
import com.meli.joyeria.dto.response.JoyaIdDTO;
import com.meli.joyeria.dto.response.JoyaListDTO;
import com.meli.joyeria.model.Joya;
import com.meli.joyeria.repository.IJoyaRepository;
import com.meli.joyeria.utils.Mapper;
import org.springframework.stereotype.Service;

@Service
public class JoyaService {
    private final IJoyaRepository repository;

    public JoyaService(IJoyaRepository repository){
        this.repository = repository;
    }
    public JoyaIdDTO addJewelry(JoyaCreationDTO joyaDto) {
        Joya joya = Mapper.mapJoyaCreationDtoToJoya(joyaDto);
        Joya result = repository.save(joya);
        return new JoyaIdDTO(result.getId());
    }

    public JoyaListDTO getAllJewelry() {
        return new JoyaListDTO(repository.findAll().stream().filter(Joya::getVentaONo).toList());
    }

    public JoyaIdDTO deleteJewelry(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        if(joya == null) return null; // Solución rápida, no es lo que se está practicando en este ejercicio

        joya.setVentaONo(false);
        return new JoyaIdDTO(joya.getId());
    }

    public JoyaCompletaDTO updateJewelry(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        if(joya == null) return null; // Solución rápida, no es lo que se está practicando en este ejercicio

        repository.save(joya);
        return Mapper.mapJoyaToJoyaCompletaDto(joya);
    }
}
