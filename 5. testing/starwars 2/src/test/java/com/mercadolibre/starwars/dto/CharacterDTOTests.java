package com.mercadolibre.starwars.dto;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterDTOTest {

    @Test
    void shouldSetAndGetName() {
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        assertEquals("Luke Skywalker", character.getName());
    }

    @Test
    void shouldSetAndGetHairColor() {
        CharacterDTO character = new CharacterDTO();
        character.setHair_color("blond");
        assertEquals("blond", character.getHair_color());
    }

    @Test
    void shouldSetAndGetSkinColor() {
        CharacterDTO character = new CharacterDTO();
        character.setSkin_color("fair");
        assertEquals("fair", character.getSkin_color());
    }

    @Test
    void shouldSetAndGetEyeColor() {
        CharacterDTO character = new CharacterDTO();
        character.setEye_color("blue");
        assertEquals("blue", character.getEye_color());
    }

    @Test
    void shouldSetAndGetBirthYear() {
        CharacterDTO character = new CharacterDTO();
        character.setBirth_year("19BBY");
        assertEquals("19BBY", character.getBirth_year());
    }

    @Test
    void shouldSetAndGetGender() {
        CharacterDTO character = new CharacterDTO();
        character.setGender("male");
        assertEquals("male", character.getGender());
    }

    @Test
    void shouldSetAndGetHomeworld() {
        CharacterDTO character = new CharacterDTO();
        character.setHomeworld("Tatooine");
        assertEquals("Tatooine", character.getHomeworld());
    }

    @Test
    void shouldSetAndGetSpecies() {
        CharacterDTO character = new CharacterDTO();
        character.setSpecies("Human");
        assertEquals("Human", character.getSpecies());
    }

    @Test
    void shouldSetAndGetHeight() {
        CharacterDTO character = new CharacterDTO();
        character.setHeight(172);
        assertEquals(172, character.getHeight());
    }

    @Test
    void shouldSetAndGetMass() {
        CharacterDTO character = new CharacterDTO();
        character.setMass(77);
        assertEquals(77, character.getMass());
    }

    @Test
    void shouldHandleNullValues() {
        CharacterDTO character = new CharacterDTO();
        assertNull(character.getName());
        assertNull(character.getHair_color());
        assertNull(character.getSkin_color());
        assertNull(character.getEye_color());
        assertNull(character.getBirth_year());
        assertNull(character.getGender());
        assertNull(character.getHomeworld());
        assertNull(character.getSpecies());
        assertNull(character.getHeight());
        assertNull(character.getMass());
    }
}