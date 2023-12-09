package com.ejercicio.covid19.repositories;

import com.ejercicio.covid19.entities.Person;
import com.ejercicio.covid19.entities.Syntom;
import com.ejercicio.covid19.entities.TypeSeverity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HealthRepositoryImpl implements IHealthRepository {

    Set<Syntom> syntoms = new HashSet<>();
    Set<Person> people = new HashSet<>();
    Map<Person, Syntom> riskPersons = new HashMap<>();

    @Bean
    private void addInformation() {
        syntoms.add(new Syntom(1, "Fiebre", TypeSeverity.ALTO));
        syntoms.add(new Syntom(2, "Color de cabeza", TypeSeverity.BAJO));
        syntoms.add(new Syntom(3, "Dolor de panza", TypeSeverity.BAJO));
        syntoms.add(new Syntom(4, "Tos", TypeSeverity.BAJO));

        people.add(new Person(1, "Tomas", "Vazquez", (byte) 22));
        people.add(new Person(2, "Sofia", "Vega", (byte) 19));
        people.add(new Person(3, "Lionel", "Messi", (byte) 35));

        riskPersons.put(
                new Person(1, "Tomas", "Vazquez", (byte) 61),
                new Syntom(1, "Fiebre", TypeSeverity.ALTO)
        );
        riskPersons.put(
                new Person(2, "Sofia", "Vega", (byte) 19),
                new Syntom(1, "Fiebre", TypeSeverity.ALTO)
        );
        riskPersons.put(
                new Person(3, "Lionel", "Messi", (byte) 78),
                new Syntom(4, "Tos", TypeSeverity.ALTO)
        );
    }

    @Override
    public Set<Syntom> getSyntoms() {
        return this.syntoms;
    }

    @Override
    public Syntom findSympton(String name) {
        return this.syntoms.stream()
                .filter(syntom -> syntom.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Person> getRiskPersons() {
        Set<Person> riskPersons = new HashSet<>();
        this.riskPersons.forEach((person, syntom) -> {
            if (person.getAge() > 60) {
                riskPersons.add(person);
            }
        });
        return riskPersons;
    }
}
