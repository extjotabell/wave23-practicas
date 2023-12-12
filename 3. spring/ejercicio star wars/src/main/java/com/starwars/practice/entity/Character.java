package com.starwars.practice.entity;

public class Character {
    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private int height;
    private int mass;

    public String getName() {
        return name;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                '}';
    }
}
