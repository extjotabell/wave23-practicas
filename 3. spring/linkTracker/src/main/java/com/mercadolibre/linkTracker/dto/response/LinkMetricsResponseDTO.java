package com.mercadolibre.linkTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data Transfer Object (DTO) representing the response for retrieving Link Tracker link metrics.
 */
@Getter @AllArgsConstructor
public class LinkMetricsResponseDTO {
    /**
     * The number of times the Link Tracker link has been redirected.
     */
    private int redirects;
}
