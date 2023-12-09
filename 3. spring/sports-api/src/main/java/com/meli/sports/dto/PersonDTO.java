package com.meli.sports.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastnName;
    private List<String> sport;
}
