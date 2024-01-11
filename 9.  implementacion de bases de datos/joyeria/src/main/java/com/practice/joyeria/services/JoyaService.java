package com.practice.joyeria.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.joyeria.dtos.JoyaDTO;
import com.practice.joyeria.dtos.JoyaResponseDTO;
import com.practice.joyeria.dtos.MessageDTO;
import com.practice.joyeria.exceptions.NotFoundException;
import com.practice.joyeria.model.Joya;
import com.practice.joyeria.repositories.JoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepository;

    public JoyaService(JoyaRepository joyaRepo) {
        this.joyaRepository = joyaRepo;
    }

    @Override
    public MessageDTO saveJewerly(JoyaDTO joyaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        Long id = joyaRepository.save(joya).getNroIdentificatorio();
        return new MessageDTO("La joya fue creada correctamente con id:"+id);
    }

    @Override
    public List<JoyaResponseDTO> getAllJewerly() {
        List<Joya> joyas = joyaRepository.findAll().stream().filter(j->j.getVentaONo().equals(true)).toList();
        ObjectMapper mapper = new ObjectMapper();
        return joyas.stream().map(j->mapper.convertValue(j, JoyaResponseDTO.class)).toList();
    }

    @Override
    public MessageDTO logicDeleteJewerly(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if(joya == null) {throw new NotFoundException("No se encontró una Joya con el id:"+id);}

        joya.setVentaONo(false);
        joyaRepository.save(joya);
        return new MessageDTO("La joya fue eliminada correctamente con id:"+id);
    }

    @Override
    public JoyaResponseDTO getJewerly(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if(joya == null) {throw new NotFoundException("No se encontró una Joya con el id:"+id);}
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(joya, JoyaResponseDTO.class);
    }

    @Override
    public JoyaResponseDTO updateJewerly(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if(joya == null) {throw new NotFoundException("No se encontró una Joya con el id:"+id);}

        ObjectMapper mapper = new ObjectMapper();
        JoyaResponseDTO joyaResponseDTO = mapper.convertValue(joyaDTO, JoyaResponseDTO.class);
        joyaResponseDTO.setNro_identificatorio(joya.getNroIdentificatorio());

        joyaRepository.save(mapper.convertValue(joyaResponseDTO, Joya.class));
        return joyaResponseDTO;
    }
}
