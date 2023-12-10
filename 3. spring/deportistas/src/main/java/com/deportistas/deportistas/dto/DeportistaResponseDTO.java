package com.deportistas.deportistas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeportistaResponseDTO {
    List<DeportistaDTO> deportista;
}
