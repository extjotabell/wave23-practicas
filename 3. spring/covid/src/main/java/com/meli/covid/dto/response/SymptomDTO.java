package com.meli.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SymptomDTO {
    private String name;
    private Integer severityLevel;
}
