package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IJoyeriaService {

    List<Joya> getJoyas();

    void createJoya(Joya joya);

    Joya readJoya(Long id);

    Joya updateJoya(Long id, String nombre, String material, Double peso, String particularidad, Boolean posee_piedra);

    void deleteJoya(Long id);

}
