package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
public class ListaDto {

    private List<PersonaDeporteDto> listaDto;

    public ListaDto() {
        this.listaDto = new ArrayList<>();
    }
}
