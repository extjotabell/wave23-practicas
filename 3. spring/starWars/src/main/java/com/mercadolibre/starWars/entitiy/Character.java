package com.mercadolibre.starWars.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Character {
    private String name;
    private String height;
    private int mass;
    private String hairColor; //tu no
    private String skinColor;  //tu no
    private String eyecolor; // tu no
    private String birthYear; //no
    private String gender;
    private String homeworld;
    private String species;

    public Character(String name, String height, int mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
