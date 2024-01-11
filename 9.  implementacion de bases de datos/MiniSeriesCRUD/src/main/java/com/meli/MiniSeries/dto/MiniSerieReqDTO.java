package com.meli.MiniSeries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class MiniSerieReqDTO {
    private String name;
    private Double rating;
    private int amountOfAwards;
}
