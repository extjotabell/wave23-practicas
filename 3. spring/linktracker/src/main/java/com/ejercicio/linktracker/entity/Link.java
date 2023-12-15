package com.ejercicio.linktracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Boolean valid;
    private Integer nroRedirecciones;
}
