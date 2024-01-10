package com.meli.jewelry.services;

import com.meli.jewelry.dtos.JewelDTO;
import com.meli.jewelry.mappers.JewelMapper;
import com.meli.jewelry.repositories.IJewelRepository;

import org.springframework.stereotype.Service;

import java.util.List;

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
        return jewelRepository.findAll().stream().map(JewelMapper::toDTO).toList();
    }

}