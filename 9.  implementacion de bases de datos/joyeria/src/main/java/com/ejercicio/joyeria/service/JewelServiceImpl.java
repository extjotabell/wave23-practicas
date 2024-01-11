package com.ejercicio.joyeria.service;

import com.ejercicio.joyeria.dto.request.JewelRequestDTO;
import com.ejercicio.joyeria.dto.response.JewelResponseDTO;
import com.ejercicio.joyeria.model.Jewel;
import com.ejercicio.joyeria.repository.IJewelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelServiceImpl implements IJewelService {
    private final IJewelRepository jewelRepository;

    public JewelServiceImpl(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDTO> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jewelRepository.findAll(), List.class);
    }

    @Override
    @Transactional(readOnly = true)
    public JewelResponseDTO findById(Long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jewelRepository.findById(id).orElse(null), JewelResponseDTO.class);
    }

    @Override
    @Transactional
    public JewelResponseDTO save(JewelRequestDTO jewel) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jewelRepository.save(objectMapper.convertValue(jewel, Jewel.class)), JewelResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Jewel jewelToUpdate = jewelRepository.findById(id).orElse(null);
        if (jewelToUpdate != null) {
            jewelToUpdate.setVentaONo(false);
            jewelRepository.save(jewelToUpdate);
        }
    }

    @Override
    public JewelResponseDTO update(Long id, JewelRequestDTO jewel) {
        ObjectMapper objectMapper = new ObjectMapper();
        Jewel jewelToUpdate = jewelRepository.findById(id).orElse(null);
        if (jewelToUpdate != null) {
            jewelToUpdate.setNombre(jewel.getNombre());
            jewelToUpdate.setMaterial(jewel.getMaterial());
            jewelToUpdate.setPeso(jewel.getPeso());
            jewelToUpdate.setPoseePiedra(jewel.isPoseePiedra());
            jewelToUpdate.setVentaONo(jewel.isVentaONo());
            jewelToUpdate.setParticularidad(jewel.getParticularidad());
            return objectMapper.convertValue(jewelRepository.save(jewelToUpdate), JewelResponseDTO.class);
        } else {
            return null;
        }
    }
}