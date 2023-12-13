package com.mercadolibre.linkTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class LinkTrackerResponseDTO {
    private String url;
    private String password;
    private int redirectCount;
}
