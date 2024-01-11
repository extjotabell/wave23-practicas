package com.meli.MiniSeries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ExceptionDTO {
    public String type;
    public String message;
}
