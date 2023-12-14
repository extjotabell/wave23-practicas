package org.ejercicio.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDto {
    private String url;
    private Integer calls;
    private Boolean active;
}
