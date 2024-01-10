package com.meli.jewelry.services;

import com.meli.jewelry.dtos.JewelDTO;
import com.meli.jewelry.entities.Jewel;

import java.util.List;

public interface IJewelService {
    public Long createJewel(JewelDTO jewelDTO);
    List<JewelDTO> getAllJewels();
}
