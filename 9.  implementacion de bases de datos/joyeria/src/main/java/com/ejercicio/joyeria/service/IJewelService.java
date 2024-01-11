package com.ejercicio.joyeria.service;

import com.ejercicio.joyeria.dto.request.JewelRequestDTO;
import com.ejercicio.joyeria.dto.response.JewelResponseDTO;
import com.ejercicio.joyeria.model.Jewel;

import java.util.List;

public interface IJewelService {
    public List<JewelResponseDTO> findAll();
    public JewelResponseDTO findById(Long id);
    public JewelResponseDTO save(JewelRequestDTO jewel);
    public void deleteById(Long id);
    public JewelResponseDTO update(Long id, JewelRequestDTO jewel);
}
