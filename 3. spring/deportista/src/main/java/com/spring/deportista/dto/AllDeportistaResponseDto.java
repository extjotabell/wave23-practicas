package com.spring.deportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllDeportistaResponseDto {
    List<DeportistaDto> deportista;
}
