package meli.demoW23Dto.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.demoW23Dto.entity.Persona;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository{
    List<Persona> data = new ArrayList<>();

    public PersonaRepositoryImpl() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        data = objectMapper.readValue(new File("/Users/mlackington/Desktop/Ejercicios Java/demoW23Dto/src/main/java/meli/demoW23Dto/repository/3. starwars.json"),new TypeReference<List<Persona>>() {});
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
