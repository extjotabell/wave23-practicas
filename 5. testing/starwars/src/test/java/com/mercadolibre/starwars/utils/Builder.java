package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static List<CharacterDTO> buildCharacterLists(String param) {
        List<CharacterDTO> list = new ArrayList<>();
        if ("Luke".equals(param)) {
            CharacterDTO lukeDTO = getLukeDTO();

            list.add(lukeDTO);
        } else if ("Darth".equals(param)) {
            CharacterDTO darthVader = getDarthVader();
            list.add(darthVader);

            CharacterDTO darthMaul = getDarthMaul();
            list.add(darthMaul);
        }
        return list;
    }

    private static CharacterDTO getDarthMaul() {
        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setHair_color("none");
        darthMaul.setSkin_color("red");
        darthMaul.setEye_color("yellow");
        darthMaul.setBirth_year("54BBY");
        darthMaul.setGender("male");
        darthMaul.setHomeworld("Dathomir");
        darthMaul.setSpecies("Zabrak");
        darthMaul.setHeight(175);
        darthMaul.setMass(80);
        return darthMaul;
    }

    private static CharacterDTO getDarthVader() {
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        return darthVader;
    }

    private static CharacterDTO getLukeDTO() {
        CharacterDTO lukeDTO = new CharacterDTO();
        lukeDTO.setName("Luke Skywalker");
        lukeDTO.setHair_color("blond");
        lukeDTO.setSkin_color("fair");
        lukeDTO.setEye_color("blue");
        lukeDTO.setBirth_year("19BBY");
        lukeDTO.setGender("male");
        lukeDTO.setHomeworld("Tatooine");
        lukeDTO.setSpecies("Human");
        lukeDTO.setHeight(172);
        lukeDTO.setMass(77);
        return lukeDTO;
    }
}
