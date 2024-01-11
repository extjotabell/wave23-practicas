package com.mercadolibre.jeweler.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JewerlyEditedDTO {
    private String message;
    private JewerlyResponseDTO jewerly;
}
