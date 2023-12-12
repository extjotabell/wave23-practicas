package com.mercadolibre.concesionariaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer kilometers;
    private String descriptions;
}
