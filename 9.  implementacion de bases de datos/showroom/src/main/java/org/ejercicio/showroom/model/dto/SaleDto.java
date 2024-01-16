package org.ejercicio.showroom.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ejercicio.showroom.model.entty.Clothes;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
    private String id;
    private Integer number;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothesList;
}
