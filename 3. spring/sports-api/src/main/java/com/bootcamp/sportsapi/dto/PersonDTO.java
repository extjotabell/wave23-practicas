package com.bootcamp.sportsapi.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastnName;
    private List<String> sport;
}
