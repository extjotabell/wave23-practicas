package com.ospina.blogYoutuber.modelo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoBlog {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

}
