package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JewelCreationDTO;
import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.dto.JewelIdDTO;
import com.example.joyerialasperlas.dto.MessageJewelDTO;
import java.util.List;

public interface IJewelService {
  JewelIdDTO createJewel(JewelCreationDTO jewelCreationDTO);
  List<JewelDTO> getAll();
  String deleteJewel(Long id);
  MessageJewelDTO updateJewel(JewelCreationDTO jewelDTO, Long id);
}
