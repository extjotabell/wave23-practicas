package com.mercadolibre.blog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.blog.dto.request.EntradaRequestDto;
import com.mercadolibre.blog.dto.response.EntradaDto;
import com.mercadolibre.blog.dto.response.EntradaIdDto;
import com.mercadolibre.blog.dto.response.EntradasDto;
import com.mercadolibre.blog.entity.EntradaBlog;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class FactoryObjetcts {

    public static EntradaRequestDto getInstanciaDeEntradaRequestDto(){
        return new EntradaRequestDto(1, "Entrada1", "Autor",LocalDate.of(2023,11,03));
    }

    public static EntradaBlog getInstanciaDeEntradaBlog(){
        return new EntradaBlog(1, "Entrada1", "Autor", LocalDate.of(2023,11,03));
    }

    public static EntradaIdDto getInstanciaDeEntradaIdDto(){
        return new EntradaIdDto(1);
    }

    public static ObjectWriter writer(){
        return  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    public static EntradaDto getInstanciaDeEntradaDto(){
    return new EntradaDto(1, "Entrada1", "Autor", LocalDate.of(2023,11,03));
    }

    public static EntradasDto getInstanciaDeEntradasDto(){
        return new EntradasDto(List.of(getInstanciaDeEntradaDto()));
    }

}
