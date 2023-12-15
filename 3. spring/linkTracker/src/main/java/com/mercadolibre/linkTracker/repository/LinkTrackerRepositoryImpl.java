package com.mercadolibre.linkTracker.repository;

import com.mercadolibre.linkTracker.entity.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the Link Tracker repository using an in-memory list.
 */
@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {

    /**
     * List to store Link Tracker entities.
     */
    private final List<LinkTracker> linkTrackerList;

    /**
     * The last assigned ID for a Link Tracker entity.
     */
    private long lastId;

    /**
     * Constructs a LinkTrackerRepositoryImpl with the specified list of Link Tracker entities.
     *
     * @param linkTrackerList The list to store Link Tracker entities.
     */
    public LinkTrackerRepositoryImpl(List<LinkTracker> linkTrackerList) {
        this.linkTrackerList = linkTrackerList;
        lastId = 0;
    }

    /**
     * Creates a new Link Tracker entity in the repository.
     *
     * @param linkTracker The Link Tracker entity to be created.
     * @return The created Link Tracker entity.
     */
    @Override
    public LinkTracker create(LinkTracker linkTracker) {
        linkTracker.setId(++lastId);
        this.linkTrackerList.add(linkTracker);
        return linkTracker;
    }

    /**
     * Retrieves a Link Tracker entity from the repository based on its ID.
     *
     * @param id The unique identifier of the Link Tracker entity.
     * @return The Link Tracker entity with the specified ID, or null if not found.
     */
    @Override
    public LinkTracker getLinkTrackerById(Long id) {
        return this.linkTrackerList.stream()
                .filter(linkTracker -> linkTracker.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Deletes a Link Tracker entity from the repository based on its ID.
     *
     * @param id The unique identifier of the Link Tracker entity to be deleted.
     * @return The deleted Link Tracker entity, or null if not found.
     */
    @Override
    public LinkTracker deleteLinkTrackerById(Long id) {
        LinkTracker res = linkTrackerList.stream().filter(linkTracker -> linkTracker.getId().equals(id)).findFirst().orElse(null);
        if (res != null) {
            linkTrackerList.remove(res);
        }
        return res;
    }
}