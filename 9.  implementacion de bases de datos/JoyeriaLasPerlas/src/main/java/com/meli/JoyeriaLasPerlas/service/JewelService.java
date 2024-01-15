package com.meli.JoyeriaLasPerlas.service;

import com.meli.JoyeriaLasPerlas.dto.request.JewelRequestDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewelResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewerlyResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.ResponseDTO;
import com.meli.JoyeriaLasPerlas.entity.Jewel;

import java.util.List;

public interface JewelService {

    ResponseDTO createJewel(JewelRequestDTO jewelRequestDTO);

    JewerlyResponseDTO getJewerly();

    ResponseDTO deleteJewel(Long id);

    JewelResponseDTO modifyJewel(Long id, JewelRequestDTO jewelRequestDTO);

}
