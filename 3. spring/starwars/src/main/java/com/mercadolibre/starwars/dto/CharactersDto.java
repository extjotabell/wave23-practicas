package com.mercadolibre.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class CharactersDto {
    private List<CharacterDto> characters;
}
