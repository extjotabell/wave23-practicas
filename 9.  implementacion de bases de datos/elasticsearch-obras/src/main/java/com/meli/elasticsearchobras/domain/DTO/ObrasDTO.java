package com.meli.elasticsearchobras.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ObrasDTO {
    private List<ObraDTO> obras;
}
