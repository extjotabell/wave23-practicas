package com.meli.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {
    private Integer code;
    private String name;
    private Integer severityLevel;
}
