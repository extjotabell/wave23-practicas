package com.ejercicio.covid19.repositories;

import com.ejercicio.covid19.entities.Person;
import com.ejercicio.covid19.entities.Syntom;

import java.util.Set;

public interface IHealthRepository {

    Set<Syntom> getSyntoms();

    Syntom findSympton(String name);

    Set<Person> getRiskPersons();
}
