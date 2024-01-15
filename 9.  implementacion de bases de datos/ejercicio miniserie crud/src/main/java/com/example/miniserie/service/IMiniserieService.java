package com.example.miniserie.service;

import com.example.miniserie.dto.MiniSerieDTO;
import com.example.miniserie.dto.MiniSeriesDTO;
import com.example.miniserie.dto.ResponseDTO;

import java.util.List;

public interface IMiniserieService {
    MiniSeriesDTO getAll();
    ResponseDTO save(MiniSerieDTO miniSerieDTO);
    ResponseDTO delete(Long id);
    MiniSerieDTO findById(Long id);
}
