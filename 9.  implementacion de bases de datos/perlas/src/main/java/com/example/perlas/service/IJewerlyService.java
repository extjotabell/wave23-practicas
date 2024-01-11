package com.example.perlas.service;

import com.example.perlas.model.Jewerly;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IJewerlyService {
    public List<Jewerly> getJewerly();

    public Integer saveJewerly(Jewerly jewerly);

    public void deleteJewerly(Integer id);

    public Jewerly findJewerly(Integer id);
}
