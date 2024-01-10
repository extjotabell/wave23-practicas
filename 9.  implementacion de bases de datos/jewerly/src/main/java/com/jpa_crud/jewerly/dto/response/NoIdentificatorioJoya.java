package com.jpa_crud.jewerly.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoIdentificatorioJoya {
    @JsonProperty("nro identificatorio")
    private Long noIdentificatorio;
}
