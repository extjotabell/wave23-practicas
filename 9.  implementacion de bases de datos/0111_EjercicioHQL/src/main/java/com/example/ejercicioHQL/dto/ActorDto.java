package com.example.ejercicioHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;

}
