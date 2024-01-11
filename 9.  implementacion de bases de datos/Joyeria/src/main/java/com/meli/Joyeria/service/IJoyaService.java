package com.meli.Joyeria.service;

import com.meli.Joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    Joya save(Joya joya);
    List<Joya> findAll();
    Joya findById(Long id);
    Joya update(Long id, Joya joya);
    boolean delete(Long id);

}
