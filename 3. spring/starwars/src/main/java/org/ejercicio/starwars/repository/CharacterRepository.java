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

    private List<Character> characterList() {
        Gson gson = new Gson();
        StringBuilder fichero = new StringBuilder();

        String rutaCompleta = "src/main/resources/starwars.json";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCompleta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                fichero.append(linea);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Type characterListType = new TypeToken<List<Character>>() {
        }.getType();
        return gson.fromJson(fichero.toString(), characterListType);
    }

    @Override
    public List<Character> findCharactersByName(String name) {
        List<Character> data = characterList();
        return data.stream().filter(character -> character.getName().contains(name)).toList();
    }
}
