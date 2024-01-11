package com.mercadolibre.jewerly.service;

import com.mercadolibre.jewerly.model.Jewel;
import com.mercadolibre.jewerly.repository.IJewelRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JewelServiceImpl implements IJewelService{

    private final IJewelRepository jewelRepository;

    public JewelServiceImpl(IJewelRepository jewelRepository){
        this.jewelRepository = jewelRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getJewels() {
        List<Jewel> jewelList = jewelRepository.findAll();
        return jewelList.stream()
                        .filter(Jewel::getSellOrNo)
                        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveJewel(Jewel jewel) {
        jewel.setSellOrNo(true);
        jewelRepository.save(jewel);
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null) {
            jewel.setSellOrNo(false);
            jewelRepository.save(jewel);
        }
    }

    @Override
    @Transactional
    public Jewel updateJewel(long id, Jewel updatedJewel) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null) {
            jewel.setName(updatedJewel.getName());
            jewel.setMaterial(updatedJewel.getMaterial());
            jewel.setWeight(updatedJewel.getWeight());
            jewel.setParticularity(updatedJewel.getParticularity());
            jewel.setHaveStone(updatedJewel.getHaveStone());
            jewel.setSellOrNo(updatedJewel.getSellOrNo());
            jewelRepository.save(jewel);
        }
        return jewel;
    }
    @Override
    public Map<String, Object> createResponse(Jewel jewel, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("message: ", message);
        response.put("jewel: ", jewel);
        return response;
    }
}
