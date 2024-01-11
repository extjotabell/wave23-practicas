package com.meli.bootcamp.jewerly.service;

import com.meli.bootcamp.jewerly.dto.BaseResponseDto;
import com.meli.bootcamp.jewerly.dto.JewerlyDto;

import java.util.List;

public interface IJewerlyService {
    BaseResponseDto save(JewerlyDto jewerlyDto);
    List<JewerlyDto> getAll();
    BaseResponseDto delete(Long id);
    JewerlyDto update(Long id, JewerlyDto jewerlyDto);
}
