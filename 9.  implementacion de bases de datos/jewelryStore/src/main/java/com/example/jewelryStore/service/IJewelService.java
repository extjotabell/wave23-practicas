package com.example.jewelryStore.service;

import com.example.jewelryStore.dto.JewelDTO;
import com.example.jewelryStore.dto.MessageDTO;

import java.util.List;

public interface IJewelService {
    MessageDTO addJewel(JewelDTO jewel);
    List<JewelDTO> getJewels();
    MessageDTO deleteJewel(Long id);
    JewelDTO updateJewel(Long id, JewelDTO jewel);

}
