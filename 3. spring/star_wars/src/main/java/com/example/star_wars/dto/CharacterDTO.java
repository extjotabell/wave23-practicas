package com.example.star_wars.dto;

import com.example.star_wars.entity.Character;

public class CharacterDTO {
    private String name;
    private Double height;
    private Double mass;
    private String eyeColor;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(Character character) {
        name = character.getName();
        eyeColor = character.getEyeColor();
        gender = character.getGender();
        homeworld = character.getHomeworld();
        species = character.getSpecies();

        try {
            height = Double.valueOf(character.getHeight());
        } catch (NumberFormatException e) {
            height = null;
        }

        try {
            mass = Double.valueOf(character.getMass());
        } catch (NumberFormatException e) {
            mass = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }


    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
