package com.mercadolibre.covid19.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonsDto {
    private List<RiskPersonDto> riskPersons;
}
