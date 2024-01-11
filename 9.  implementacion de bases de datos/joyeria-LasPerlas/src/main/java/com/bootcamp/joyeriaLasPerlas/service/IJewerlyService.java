package com.bootcamp.joyeriaLasPerlas.service;

import com.bootcamp.joyeriaLasPerlas.dto.request.JewerlyDto;
import com.bootcamp.joyeriaLasPerlas.model.Jewerly;

import java.util.List;

public interface IJewerlyService {

    public List<Jewerly> getJewerlys();
    public void saveJewerly(Jewerly jewerly);
    public void deleteJewerly(long id);
    public Jewerly findJewerly(long id);

    Jewerly updateJewerly(Jewerly jewerly, JewerlyDto jewerlyDto);
}
