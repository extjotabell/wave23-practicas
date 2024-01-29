package com.example.Deportistas.DTOs;

import com.spring.DTO.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PersonSportDTO {
    private String name;
    private String lastname;
    private List<String> sport;
}
