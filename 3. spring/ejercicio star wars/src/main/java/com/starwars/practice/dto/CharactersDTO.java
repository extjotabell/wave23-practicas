package com.starwars.practice.dto;

import java.io.Serializable;
import java.util.List;

public class CharactersDTO {
    private List<CharacterDTO> characters;

    public CharactersDTO() {
    }

    public CharactersDTO(List<CharacterDTO> characters) {
        this.characters = characters;
    }

    public List<CharacterDTO> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterDTO> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "CharactersDTO{" +
                "characters=" + characters +
                '}';
    }
}
