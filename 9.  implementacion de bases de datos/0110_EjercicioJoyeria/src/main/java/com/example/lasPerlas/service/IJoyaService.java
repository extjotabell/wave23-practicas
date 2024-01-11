package com.example.lasPerlas.service;

import com.example.lasPerlas.dto.NewJoyaRequestDto;
import com.example.lasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public List<Joya> getAllJoyas();
    public Joya findOne(Long id);
    public Joya save(NewJoyaRequestDto joya);
    public boolean delete(Long id);
    public Joya update(Long id, NewJoyaRequestDto updatedJoya);

}
