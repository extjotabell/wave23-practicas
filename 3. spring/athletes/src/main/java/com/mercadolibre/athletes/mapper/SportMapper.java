package com.mercadolibre.athletes.mapper;

import com.mercadolibre.athletes.dto.AthleteDTO;
import com.mercadolibre.athletes.dto.SportDTO;
import com.mercadolibre.athletes.entity.Athlete;
import com.mercadolibre.athletes.entity.Sport;
import org.springframework.stereotype.Component;

/**
 * Component responsible for mapping entities to DTOs for sports-related operations.
 *  @Component is used to declare the SportMapper as a Spring-managed component, making it available for dependency
 *  injection and facilitating the use of Spring's IoC capabilities in the application.
 */
@Component
public class SportMapper {

    /**
     * Maps a Sport entity to a SportDTO.
     *
     * @param sport The Sport entity to be mapped.
     * @return SportDTO representing the mapped sport.
     */
    public SportDTO mapSportToDTO(Sport sport) {
        return new SportDTO(sport.getName(), sport.getLevel());
    }

    /**
     * Maps an Athlete entity to an AthleteDTO.
     *
     * @param athlete The Athlete entity to be mapped.
     * @return AthleteDTO representing the mapped athlete.
     */
    public AthleteDTO mapPersonToDTO(Athlete athlete) {
        return new AthleteDTO(athlete.getName(), athlete.getLastname(), athlete.getSport().getName());
    }
}