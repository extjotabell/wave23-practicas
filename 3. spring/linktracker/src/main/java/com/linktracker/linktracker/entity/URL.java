package com.linktracker.linktracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class URL {
    private Integer id;
    private String url;
    private String password;
    private Boolean valido;
    private Integer numeroRedirecciones;
}
