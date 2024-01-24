package com.mercadolibre.deportistas.reposotory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.deportistas.dto.SportDTO;
import com.mercadolibre.deportistas.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SportRepositoryImpl implements ISportRepository{

    private List<Sport> sports;

    public SportRepositoryImpl() {
        Sport swimmingInitial = new Sport("Natación","Inicial");
        Sport swimmingMedium = new Sport("Natación","Intermedio");
        Sport swimmingAdvanced = new Sport("Natación","Avanzado");

        Sport footballInitial = new Sport("Fútbol","Básico");
        Sport footballAdvanced = new Sport("Fútbol","Avanzado");

        this.sports = List.of(swimmingInitial,swimmingMedium,swimmingAdvanced,footballInitial,footballAdvanced);
    }

    @Override
    public List<Sport> findAll() {
        return this.sports;
    }

    @Override
    public List<String> getLevelsBySportName(String name) {
        List<Sport> filteredSports = this.sports.stream()
                .filter(sport -> sport.getName().equals(name)).toList();

        List<String> levels = new ArrayList<>();

        for (Sport sport : filteredSports) {
            levels.add(sport.getLevel());
        }

        return levels;
    }


}
