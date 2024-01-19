package com.mercadolibre.demo.services;

import com.mercadolibre.demo.dtos.JewelDTO;
import com.mercadolibre.demo.dtos.MessageDTO;
import com.mercadolibre.demo.models.Jewel;
import java.util.List;

public interface IJewelService {
    public MessageDTO saveJewel(Jewel jewel);
    public List<JewelDTO> getAll();
    public MessageDTO deleteJewel(Long id) throws Exception;

    MessageDTO updateJewel(Long id, JewelDTO jewel);
}
