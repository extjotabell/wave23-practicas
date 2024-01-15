package com.example.showroom.model.dto;

import com.example.showroom.model.entity.Cloth;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleDTO {
    @JsonIgnore
    private Integer number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private double total;
    private String paidMethod;
    private List<Cloth> cloths;
}
