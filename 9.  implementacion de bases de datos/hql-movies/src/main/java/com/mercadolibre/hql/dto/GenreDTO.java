package com.mercadolibre.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private byte active;
}
