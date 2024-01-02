package com.mercadolibre.be_java_hisp_w23_g2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDTO {
    private String explanation;
    private List<String> message;
}
