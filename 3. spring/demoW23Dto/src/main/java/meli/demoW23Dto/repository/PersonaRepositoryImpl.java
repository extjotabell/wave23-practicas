package meli.demoW23Dto.repository;

import meli.demoW23Dto.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository{
    List<Persona> data = new ArrayList<>();

    public PersonaRepositoryImpl(){
        loadData();
    }

    private void loadData(){
        data.add(new Persona("Martin","Marquez",32));
        data.add(new Persona("Carlos","Perez",23));
        data.add(new Persona("Maria","Gomez",35));
    }

    @Override
    public List<Persona> findAll() {
        return data;
    }

    @Override
    public void savePeople(Persona p) {
        data.add(p);
    }
}
