package com.mercadolibre.linktracker.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkTrackerMetricsDto {
    int linkTrackerId;
    Integer redirections;
}
