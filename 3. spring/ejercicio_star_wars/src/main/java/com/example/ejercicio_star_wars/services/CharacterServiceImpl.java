package com.example.ejercicio_star_wars.services;

import com.example.ejercicio_star_wars.entities.Character;
import com.example.ejercicio_star_wars.dtos.request.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ejercicio_star_wars.repositorys.CharacterRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    CharacterRepositoryImpl repository;

    @Override
    public List<CharacterDto> findCharacter(String variable) throws Exception {
        List<CharacterDto> respuesta = new ArrayList<>();

        List<Character> personaList = repository.findAll();

        List<Character> filtrada = personaList.stream().filter(persona ->
                persona.getName().contains(variable)
        ).toList();

        if (filtrada.isEmpty()){
            throw new Exception("No hay datos");
        }

        for (Character aux: filtrada
        ) {
            respuesta.add(new CharacterDto(aux.getName(),
                    aux.getHeight(),
                    aux.getMass(),
                    aux.getGender(),
                    aux.getHomeworld(),
                    aux.getSpecies()));
        }

        return respuesta;
    }
}


