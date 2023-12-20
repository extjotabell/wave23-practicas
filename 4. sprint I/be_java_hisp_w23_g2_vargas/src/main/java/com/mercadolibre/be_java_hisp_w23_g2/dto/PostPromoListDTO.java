package com.mercadolibre.be_java_hisp_w23_g2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoListDTO {
    private List<PostPromoDTO> promos_category;
}
