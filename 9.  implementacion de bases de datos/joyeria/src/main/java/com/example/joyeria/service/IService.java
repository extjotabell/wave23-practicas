package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import java.util.List;

public interface IService {
    Long createJoya(JoyaDTO joyaDTO);
    List<JoyaDTO> getJoyas();
    void deleteJoya(Long id);
    JoyaDTO updateJoya (Long id, JoyaDTO joyaDTO);
}
