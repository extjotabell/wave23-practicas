package com.mercadolibre.jewerly.service;

import com.mercadolibre.jewerly.model.Jewel;

import java.util.List;
import java.util.Map;

public interface IJewelService {

    public List<Jewel> getJewels();
    public void saveJewel(Jewel jewel);
    public void deleteJewel(long id);
    public Jewel updateJewel(long id, Jewel updatedJewel);
    public Map<String, Object> createResponse(Jewel jewel, String message);
}
