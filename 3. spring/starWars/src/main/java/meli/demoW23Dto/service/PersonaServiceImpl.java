package meli.demoW23Dto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.demoW23Dto.dto.request.PersonaDto;
import meli.demoW23Dto.dto.response.ResponseSaveDto;
import meli.demoW23Dto.entity.Persona;
import meli.demoW23Dto.repository.PersonaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    PersonaRepositoryImpl repository;

    @Override
    public List<PersonaDto> findCharacter(String variable) throws Exception {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> personaList = repository.findAll();

        List<Persona> filtrada = personaList.stream().filter(persona ->
            persona.getName().contains(variable)
        ).toList();

        if (filtrada.isEmpty()){
            throw new Exception("No hay datos");
        }

        for (Persona aux: filtrada
             ) {
            respuesta.add(new PersonaDto(aux.getName(),
                    aux.getHeight(),
                    aux.getMass(),
                    aux.getGender(),
                    aux.getHomeworld(),
                    aux.getSpecies()));
        }

        return respuesta;
    }


}
