package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerCreatedResponseDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;

public interface ILinkTrackerService {
    LinkTrackerCreatedResponseDTO create(LinkTrackerDTO linkTracker);
    String getRedirectUrl(Long id);
    int getMetrics(Long linkId);

    LinkTrackerResponseDTO invalidate(Long linkId);
}
