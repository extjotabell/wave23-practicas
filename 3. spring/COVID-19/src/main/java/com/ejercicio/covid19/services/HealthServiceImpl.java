package com.ejercicio.covid19.services;

import com.ejercicio.covid19.dto.response.RiskPersonDto;
import com.ejercicio.covid19.dto.response.SyntomDto;
import com.ejercicio.covid19.entities.Person;
import com.ejercicio.covid19.entities.Syntom;
import com.ejercicio.covid19.exceptions.NotRiskPersonsOnSistem;
import com.ejercicio.covid19.exceptions.NotSyntomFindedWithName;
import com.ejercicio.covid19.exceptions.NotSyntomsOnSistem;
import com.ejercicio.covid19.repositories.IHealthRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class HealthServiceImpl implements IHealthService {

    @Autowired
    IHealthRepository healthRepository;

    @Override
    public Set<Syntom> getSyntoms() throws NotSyntomsOnSistem {
        Set<Syntom> syntoms = this.healthRepository.getSyntoms();
        if (syntoms.isEmpty()) {
            throw new NotSyntomsOnSistem();
        }
        return syntoms;
    }

    @Override
    public SyntomDto findSympton(String name) throws NotSyntomFindedWithName {
        Syntom syntom = this.healthRepository.findSympton(name);
        if (syntom == null) {
            throw new NotSyntomFindedWithName();
        }
        return new SyntomDto(syntom.getTypeSeverity());
    }

    @Override
    public Set<RiskPersonDto> getRiskPersons() throws NotRiskPersonsOnSistem {
        Set<RiskPersonDto> riskPersonDtos = new HashSet<>();
        Set<Person> persons = this.healthRepository.getRiskPersons();
        if (persons.isEmpty()) {
            throw new NotRiskPersonsOnSistem();
        }
        persons.forEach(person -> {
            riskPersonDtos.add(new RiskPersonDto(person.getName(), person.getSurname()));
        });
        return riskPersonDtos;
    }
}
