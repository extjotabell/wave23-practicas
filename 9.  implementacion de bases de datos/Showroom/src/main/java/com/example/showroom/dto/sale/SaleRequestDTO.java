package com.example.showroom.dto.sale;

import com.example.showroom.dto.clothe.ClotheRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequestDTO {
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("clothes_by_id")
    private List<Long> clothesById;
}
