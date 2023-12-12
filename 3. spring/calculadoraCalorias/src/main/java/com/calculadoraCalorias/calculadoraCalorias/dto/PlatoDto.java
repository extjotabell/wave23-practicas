package com.calculadoraCalorias.calculadoraCalorias.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class PlatoDto {
    private String name;
    private int weight;
}
