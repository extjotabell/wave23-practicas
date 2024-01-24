package com.mercadolibre.deportistas.reposotory;

import com.mercadolibre.deportistas.entity.Person;
import com.mercadolibre.deportistas.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository {

    List<Person> persons;

    public PersonRepositoryImpl(List<Person> persons) {
        Sport swimmingMedium = new Sport("Natación","Intermedio");
        Sport swimmingAdvanced = new Sport("Natación","Avanzado");
        Sport footballInitial = new Sport("Fútbol","Básico");

        Person personSM = new Person("Lautaro","Peralta", 28, swimmingMedium);
        Person personSA = new Person("Micaela","López", 32, swimmingAdvanced);
        Person personFI = new Person("Javier","Gómez", 16, footballInitial);

        this.persons = List.of(personSM,personSA,personFI);
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }
}
