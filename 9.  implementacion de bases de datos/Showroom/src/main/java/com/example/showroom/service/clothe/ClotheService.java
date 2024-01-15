package com.example.showroom.service;

import com.example.showroom.dto.ClotheRequestDTO;
import com.example.showroom.dto.ClotheResponseDTO;

import java.util.List;

public interface ClotheService {
    void save(ClotheRequestDTO clotheRequestDTO);

    List<ClotheResponseDTO> findAll(String containsInName);

    ClotheResponseDTO findById(Long id);

    void updateById(Long id, ClotheRequestDTO clotheRequestDTO);

    void delete(Long id);

    List<ClotheResponseDTO> findBySize(String size);
}
