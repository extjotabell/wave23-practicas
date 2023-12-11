package meli.demoW23Dto.repository;

import meli.demoW23Dto.entity.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> findAll();
    void savePeople(Persona p);
}
