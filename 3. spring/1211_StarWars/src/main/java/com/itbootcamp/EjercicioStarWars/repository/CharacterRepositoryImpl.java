package com.itbootcamp.EjercicioStarWars.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbootcamp.EjercicioStarWars.entity.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {

    private final List<Character> characterList = new ArrayList<>();

    public CharacterRepositoryImpl(){
        loadData();
    }

    private void loadData(){
        //characterList.add(new Character("Luke Skywalker", 170, 70, "Brown", "White", "Brown", "19901010", "M", "Nabú", "Human"));
        String jsonFilePath = "static/starwars.json";
        try (InputStream inputStream = new ClassPathResource(jsonFilePath).getInputStream()){
            if(inputStream != null){
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(inputStream);
                if(jsonNode.isArray()){
                    Iterator<JsonNode> elements = jsonNode.elements();
                    while(elements.hasNext()){
                        JsonNode element = elements.next();
                        characterList.add(new Character(
                                element.get("name").asText(),
                                element.get("height").asInt(),
                                element.get("mass").asInt(),
                                element.get("hair_color").asText(),
                                element.get("skin_color").asText(),
                                element.get("eye_color").asText(),
                                element.get("birth_year").asText(),
                                element.get("gender").asText(),
                                element.get("homeworld").asText(),
                                element.get("species").asText()
                        ));
                    }
                }
            }else{
                System.out.println("Error al abrir el JSON");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Character> findAll() {
        return characterList;
    }


    @Override
    public void saveCharacter(Character newCharacter) {
        characterList.add(newCharacter);
    }

    @Override
    public List<Character> findByName(String name) {
        return characterList.stream()
                .filter(character -> character.getName().contains(name))
                .toList();
    }
}
