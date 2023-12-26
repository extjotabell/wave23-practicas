package org.ejercicio.starwars.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ejercicio.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


@Repository
public class CharacterRepository implements ICharacterRepository {

    private List<Character> getInformation() {
        Gson gson = new Gson();
        StringBuilder file = new StringBuilder();

        String fullRoute = "src/main/resources/starwars.json";

        try (BufferedReader br = new BufferedReader(new FileReader(fullRoute))) {
            String line;
            while ((line = br.readLine()) != null) {
                file.append(line);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Type characterListType = new TypeToken<List<Character>>() {
        }.getType();
        return gson.fromJson(file.toString(), characterListType);
    }

    @Override
    public List<Character> findCharactersByName(String name) {
        List<Character> data = getInformation();
        return data.stream().filter(character -> character.getName().contains(name)).toList();
    }
}
