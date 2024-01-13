package com.jpa.hql.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ActorDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private MovieDTO favoriteMovie;
}
