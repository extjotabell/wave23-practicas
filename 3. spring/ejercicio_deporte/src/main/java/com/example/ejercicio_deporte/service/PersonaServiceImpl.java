package com.example.ejercicio_deporte.service;

import com.example.ejercicio_deporte.dto.PersonaDto;
import com.example.ejercicio_deporte.entity.Persona;
import com.example.ejercicio_deporte.repository.PersonaRepositoyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    PersonaRepositoyImpl service;
    @Override
    public List<PersonaDto> getAllPersona() {
        List<PersonaDto> respuesta = new ArrayList<>();

        List<Persona> listaFiltrada = service.findAll();

        for (Persona aux: listaFiltrada
             ) {
            respuesta.add(new PersonaDto(aux.getName(),
                    aux.getLastName(),
                    aux.getAge()));
        }
        return respuesta;
    }
}
