package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;

public interface ILinkTrackerService {
    LinkTrackerResponseDTO create(LinkTrackerDTO linkTracker);
    String getRedirectUrl(Long id);
    int getMetrics();
}
