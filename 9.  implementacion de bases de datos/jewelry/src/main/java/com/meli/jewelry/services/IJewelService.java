package com.meli.jewelry.services;

import com.meli.jewelry.dtos.request.JewelDTO;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IJewelService {
    public Long createJewel(JewelDTO jewelDTO);
    List<JewelDTO> getAllJewels();
    void deleteJewel(Long id);
}