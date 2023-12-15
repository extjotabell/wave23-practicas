package com.mercadolibre.covid19.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonDto {
    private String name;
    private String lastname;
    private Integer age;
    private String symptomName;
    private String severity_level;
}
