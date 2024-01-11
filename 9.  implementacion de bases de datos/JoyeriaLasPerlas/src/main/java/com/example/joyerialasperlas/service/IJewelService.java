package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.dto.JoyaIdDTO;

public interface IJoyaService {
  JoyaIdDTO createJoya(JewelDTO joya);
}
