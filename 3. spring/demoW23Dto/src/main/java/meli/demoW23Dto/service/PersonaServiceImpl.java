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
    public List<PersonaDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> personaList = repository.findAll();

        personaList.stream().forEach(p-> {
            respuesta.add(mapper.convertValue(p,PersonaDto.class));
        });

        return respuesta;
    }

    @Override
    public ResponseSaveDto savePeople(PersonaDto personaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Persona persona = mapper.convertValue(personaDto,Persona.class);
        repository.savePeople(persona);
        return new ResponseSaveDto("Se guardó todo ok...");
    }


}
