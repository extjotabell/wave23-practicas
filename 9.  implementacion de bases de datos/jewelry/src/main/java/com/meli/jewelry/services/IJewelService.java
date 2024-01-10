package com.meli.jewelry.services;

import com.meli.jewelry.dtos.JewelDTO;
import com.meli.jewelry.entities.Jewel;

public interface IJewelService {
    public Long createJewel(JewelDTO jewelDTO);
}
