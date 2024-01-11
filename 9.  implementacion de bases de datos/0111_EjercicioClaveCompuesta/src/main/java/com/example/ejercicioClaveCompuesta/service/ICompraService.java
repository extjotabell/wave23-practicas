package com.example.ejercicioClaveCompuesta.service;

import com.example.ejercicioClaveCompuesta.dto.CompraResponseDto;
import com.example.ejercicioClaveCompuesta.dto.NewCompraRequestDto;

import java.util.List;

public interface ICompraService {

    public void save(NewCompraRequestDto newCompraRequestDto);
    public List<CompraResponseDto> findAll();

}
