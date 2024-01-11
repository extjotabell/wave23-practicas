package com.meli.jewelry.services.impl;

import com.meli.jewelry.dtos.request.JewelDTO;

import java.util.List;

public interface IJewelService {
    public Long createJewel(JewelDTO jewelDTO);
    List<JewelDTO> getAllJewels();
    void deleteJewel(Long id);
    JewelDTO updateJewel(Long id, JewelDTO jewelDTO);
}