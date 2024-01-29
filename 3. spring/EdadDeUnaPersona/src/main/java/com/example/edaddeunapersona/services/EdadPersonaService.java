package com.example.edaddeunapersona.services;


import com.example.edaddeunapersona.dto.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EdadPersonaService {

    private List<Persona> personas = new ArrayList<>();

    public int calcularEdad(int day, int month, int year) {
        LocalDate now = LocalDate.now();

        return now.getMonthValue() > month || now.getMonthValue() == month && now.getDayOfMonth() >= day ?
                (now.getYear() - year) : (now.getYear() - year - 1);
    }

    public void agregarPersona(Persona p, int day, int month, int year) {
        p.setEdad(calcularEdad(day, month, year));
        personas.add(p);
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}
