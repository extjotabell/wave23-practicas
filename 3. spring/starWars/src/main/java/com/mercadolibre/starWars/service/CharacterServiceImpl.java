package com.mercadolibre.starWars.service;

import com.mercadolibre.starWars.dto.CharacterResponseDTO;
import com.mercadolibre.starWars.entity.Character;
import com.mercadolibre.starWars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mercadolibre.starWars.utils.mapper.CharacterMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ICharacterService interface that manages Star Wars characters.
 */
@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    private ICharacterRepository repository;

    /**
     * Retrieves details of all characters from the Star Wars universe.
     *
     * @return List of CharacterResponseDTO containing details of all characters.
     */
    @Override
    public List<CharacterResponseDTO> getAllCharacters(){
        List<Character> characterList = repository.getAllCharacters();

        return mapCharacterListToDTOList(characterList);
    }

    /**
     * Retrieves details of characters by their name from the Star Wars universe.
     *
     * @param name The name of the character or a portion of the name to search for.
     * @return List of CharacterResponseDTO containing details of characters matching the provided name.
     */
    @Override
    public List<CharacterResponseDTO> getCharacterByName(String name) {
        List<Character> characterList = repository.getCharacterByName(name);

        return mapCharacterListToDTOList(characterList);
    }

    /**
     * Maps a list of Character entities to a list of CharacterResponseDTO using the CharacterMapper.
     *
     * @param characterList List of Character entities to be mapped.
     * @return List of CharacterResponseDTO containing mapped character details.
     */
    private List<CharacterResponseDTO> mapCharacterListToDTOList(List<Character> characterList) {
        return characterList.stream()
                .map(CharacterMapper::mapCharacterToDTO)
                .collect(Collectors.toList());
    }
}
