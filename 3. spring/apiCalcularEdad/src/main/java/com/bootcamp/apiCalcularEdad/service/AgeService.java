package com.bootcamp.apiCalcularEdad.service;
import com.bootcamp.apiCalcularEdad.entities.Persona;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgeService {
    List<Persona> personaList = new ArrayList<>();

    public Persona setAge(int day, int month,int year,Persona p){
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.of(year,month,day);
        for(Persona persona : personaList){
            if(persona.getId() == p.getId()){
                p.setEdad(ChronoUnit.YEARS.between(birth,today));
            }
        }
        return p;
    }
    public List<Persona> getAll(){
        return personaList;
    }

    public Persona save(Persona p){
        personaList.add(p);
        return p;
    }
}
