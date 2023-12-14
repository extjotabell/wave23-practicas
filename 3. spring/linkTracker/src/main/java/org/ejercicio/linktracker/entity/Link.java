package org.ejercicio.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private String password;
    private Integer calls;
    private Boolean active;
}
