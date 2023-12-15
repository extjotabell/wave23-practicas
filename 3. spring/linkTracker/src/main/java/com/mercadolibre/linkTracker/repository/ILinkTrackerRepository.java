package com.mercadolibre.linkTracker.repository;

import com.mercadolibre.linkTracker.entity.LinkTracker;

/**
 * Interface defining operations for Link Tracker repository.
 */
public interface ILinkTrackerRepository {

    /**
     * Creates a new Link Tracker entity in the repository.
     *
     * @param linkTracker The Link Tracker entity to be created.
     * @return The created Link Tracker entity.
     */
    LinkTracker create(LinkTracker linkTracker);

    /**
     * Retrieves a Link Tracker entity from the repository based on its ID.
     *
     * @param id The unique identifier of the Link Tracker entity.
     * @return The Link Tracker entity with the specified ID, or null if not found.
     */
    LinkTracker getLinkTrackerById(Long id);

    /**
     * Deletes a Link Tracker entity from the repository based on its ID.
     *
     * @param id The unique identifier of the Link Tracker entity to be deleted.
     * @return The deleted Link Tracker entity, or null if not found.
     */
    LinkTracker deleteLinkTrackerById(Long id);
}