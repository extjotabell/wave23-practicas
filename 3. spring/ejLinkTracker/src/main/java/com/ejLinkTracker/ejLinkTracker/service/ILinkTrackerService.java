package com.ejLinkTracker.ejLinkTracker.service;

import com.ejLinkTracker.ejLinkTracker.dto.request.LinkTrackerDTO;
import com.ejLinkTracker.ejLinkTracker.dto.response.LinkTrackerCreatedResponseDTO;
import com.ejLinkTracker.ejLinkTracker.dto.response.LinkTrackerResponseDTO;

public interface ILinkTrackerService {
    LinkTrackerCreatedResponseDTO create(LinkTrackerDTO linkTracker);
    String getRedirectUrl(Long id);
    int getMetrics(Long linkId);
    LinkTrackerResponseDTO invalidate(Long linkId);
}
