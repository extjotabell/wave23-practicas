package com.meli.JoyeriaLasPerlas.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JewerlyResponseDTO {
    @JsonProperty("jewerly_list")
    private List<JewelResponseDTO> jewelResponseDTOList;

}
