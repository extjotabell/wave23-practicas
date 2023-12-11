package com.mercadolibre.starWars.utils.mapper;

import com.mercadolibre.starWars.entity.Character;
import com.mercadolibre.starWars.dto.CharacterResponseDTO;

/**
 * Mapper class to convert instances of {@link Character} to {@link CharacterResponseDTO}.
 */
public class CharacterMapper {

    /**
     * Maps a {@link Character} object to a {@link CharacterResponseDTO} object.
     *
     * @param character The {@link Character} object to be mapped.
     * @return A new {@link CharacterResponseDTO} object with mapped fields.
     * @throws IllegalArgumentException if the input {@code character} is {@code null}.
     */
    public static CharacterResponseDTO mapCharacterToDTO(Character character){
        return new CharacterResponseDTO(
                character.getName(), character.getHeight(), character.getMass(),
                character.getGender(), character.getHomeworld(), character.getSpecies()
        );
    }
}
