package com.jpa.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreDTO {
    private Integer id;
    private String name;
    private Integer ranking;
}
