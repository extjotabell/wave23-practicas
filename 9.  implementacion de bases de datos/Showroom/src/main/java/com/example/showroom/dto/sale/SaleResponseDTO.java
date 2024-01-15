package com.example.showroom.dto.sale;

import com.example.showroom.dto.clothe.ClotheResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDTO {
    private Long id;
    private LocalDate date;
    @JsonProperty("sale_total")
    private Double saleTotal;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<ClotheResponseDTO> clothes;
}
