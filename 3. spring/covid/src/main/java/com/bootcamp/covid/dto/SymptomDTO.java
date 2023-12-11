package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SymptomDTO {
    private String name;
    private String severityLevel;
}
