package com.meli.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RiskPersonDTO {
    private String fullName;
    private Integer age;
    private String symptom;
    private Integer severityLevel;
}
