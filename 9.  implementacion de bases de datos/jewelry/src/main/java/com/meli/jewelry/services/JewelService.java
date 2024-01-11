package com.meli.jewelry.services;

import com.meli.jewelry.dtos.request.JewelDTO;
import com.meli.jewelry.entities.Jewel;
import com.meli.jewelry.exceptions.custom.NotFoundException;
import com.meli.jewelry.mappers.JewelMapper;
import com.meli.jewelry.repositories.IJewelRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelService implements IJewelService{

    private final IJewelRepository jewelRepository;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public Long createJewel(JewelDTO jewelDTO) {
        return jewelRepository.save(JewelMapper.toEntity(jewelDTO)).getIdentityNumber();
    }

    @Override
    public List<JewelDTO> getAllJewels() {
        return jewelRepository.findAll().stream()
                                        .map(JewelMapper::toDTO)
                                        .filter(JewelDTO::getAvailable).toList();
    }

    @Override
    public void deleteJewel(Long id) {
        Optional<Jewel> jewel = jewelRepository.findById(id);
        if (jewel.isEmpty()) throw new NotFoundException("Jewel not found");

        jewel.get().setAvailable(false);
        jewelRepository.save(jewel.get());
    }
}