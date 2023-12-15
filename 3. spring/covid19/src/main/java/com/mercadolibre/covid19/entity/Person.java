package com.mercadolibre.covid19.entity;

import lombok.*;

import java.util.List;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
}
