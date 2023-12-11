package com.example.star_wars.service;

import com.example.star_wars.dto.CharacterDTO;

import java.util.List;

public interface Service {
    List<CharacterDTO> filterByName(String filterParam);
}
