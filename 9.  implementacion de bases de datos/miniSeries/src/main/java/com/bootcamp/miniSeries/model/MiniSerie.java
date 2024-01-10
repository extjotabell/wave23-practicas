package com.bootcamp.miniSeries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="miniSerie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    Double rating;
    int amount_of_awards;

    public MiniSerie() {

    }

    public void setId(Long id) {
        this.id = id;
    }


}
