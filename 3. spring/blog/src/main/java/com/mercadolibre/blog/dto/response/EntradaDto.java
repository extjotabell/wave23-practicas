package com.mercadolibre.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDto {
    private Integer id;
    private String titulo;
    private String autor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
