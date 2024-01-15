package com.example.showroom.service.clothe;

import com.example.showroom.dto.clothe.ClotheRequestDTO;
import com.example.showroom.dto.clothe.ClotheResponseDTO;
import com.example.showroom.repository.ClotheRepository;
import com.example.showroom.service.clothe.ClotheService;
import com.example.showroom.util.ClotheDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheServiceImpl implements ClotheService {

    private final ClotheRepository clotheRepository;

    public ClotheServiceImpl(ClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    @Override
    public void save(ClotheRequestDTO clotheRequestDTO) {
        clotheRepository.save(ClotheDTOMapper.mapToClothe(clotheRequestDTO));
    }

    @Override
    public List<ClotheResponseDTO> findAll(String containsInName) {
        if (containsInName == null)
            return clotheRepository.findAll()
                    .stream().map(ClotheDTOMapper::mapToClotheResponseDTO).toList();
        return clotheRepository.findClothesByNameContaining(containsInName)
                .stream().map(ClotheDTOMapper::mapToClotheResponseDTO).toList();
    }

    @Override
    public ClotheResponseDTO findById(Long id) {
        return clotheRepository.findById(id)
                .map(ClotheDTOMapper::mapToClotheResponseDTO).orElseThrow();
    }

    @Override
    public void updateById(Long id, ClotheRequestDTO clotheRequestDTO) {
        clotheRepository.findById(id).ifPresent(clothe -> {
            clothe.setName(clotheRequestDTO.getName());
            clothe.setType(clotheRequestDTO.getType());
            clothe.setBrand(clotheRequestDTO.getBrand());
            clothe.setColor(clotheRequestDTO.getColor());
            clothe.setSize(clotheRequestDTO.getSize());
            clothe.setQuantity(clotheRequestDTO.getQuantity());
            clothe.setSalePrice(clotheRequestDTO.getSalePrice());
        });
    }

    @Override
    public void delete(Long id) {
        clotheRepository.delete(
                clotheRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ClotheResponseDTO> findBySize(String size) {
        return clotheRepository.findClothesBySize(size)
                .stream().map(ClotheDTOMapper::mapToClotheResponseDTO).toList();
    }
}
