package com.example.seguroAutos.service;

import com.example.seguroAutos.dto.AutoDto;
import com.example.seguroAutos.dto.MessageDto;

import java.util.List;

public interface AutoService {
    List<String> getPatentes();

    MessageDto addAuto(AutoDto auto);

    List<String> getPatenteMarcaOrdenado();
}
