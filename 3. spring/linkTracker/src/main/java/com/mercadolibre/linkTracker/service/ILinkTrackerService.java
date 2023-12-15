package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;

/**
 * Interface defining operations for the Link Tracker service.
 */
public interface ILinkTrackerService {

    /**
     * Creates a new Link Tracker link based on the provided DTO.
     *
     * @param linkTracker DTO containing information for the new Link Tracker link.
     * @return Response DTO with the result of the creation and the ID of the new link.
     */
    LinkTrackerResponseDTO create(LinkTrackerDTO linkTracker);

    /**
     * Retrieves the redirect URL for a specific Link Tracker link.
     *
     * @param id       The ID of the Link Tracker link.
     * @param password Optional password for link validation.
     * @return The redirect URL if the link is valid, or an error message if not.
     */
    String getRedirectUrl(Long id, String password);

    /**
     * Retrieves the redirect metrics for a specific Link Tracker link.
     *
     * @param id The ID of the Link Tracker link.
     * @return The number of times the link has been redirected.
     */
    int getMetrics(Long id);
}