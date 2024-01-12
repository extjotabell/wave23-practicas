package com.meli.obrasliterarias.mappers;

import com.meli.obrasliterarias.dtos.ObraLiterariaDTO;
import com.meli.obrasliterarias.entities.ObraLiteraria;

public class ObraLiterariaMapper {

    private ObraLiterariaMapper(){}

    public static ObraLiterariaDTO toDTO(ObraLiteraria obraLiteraria){
        return new ObraLiterariaDTO(obraLiteraria.getNombre(),
                                    obraLiteraria.getAutor(),
                                    obraLiteraria.getCantidadDePaginas(),
                                    obraLiteraria.getEditorial(),
                                    obraLiteraria.getPrimeraPublicacion());
    }

    public static ObraLiteraria toEntity(ObraLiterariaDTO obraLiterariaDTO){
        return new ObraLiteraria(null,
                                 obraLiterariaDTO.getNombre(),
                                 obraLiterariaDTO.getAutor(),
                                 obraLiterariaDTO.getCantidadDePaginas(),
                                 obraLiterariaDTO.getEditorial(),
                                 obraLiterariaDTO.getPrimeraPublicacion());
    }
}
