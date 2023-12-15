package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;
import com.mercadolibre.linkTracker.exception.LinkTrackerNotFoundException;
import com.mercadolibre.linkTracker.repository.ILinkTrackerRepository;
import com.mercadolibre.linkTracker.repository.LinkTrackerRepositoryImpl;
import org.springframework.stereotype.Service;

/**
 * Implementation of the Link Tracker service.
 */
@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {

    /**
     * Repository for Link Tracker entities.
     */
    private final ILinkTrackerRepository repository;

    /**
     * Constructs a LinkTrackerServiceImpl with the specified Link Tracker repository.
     *
     * @param repository The Link Tracker repository implementation.
     */
    public LinkTrackerServiceImpl(LinkTrackerRepositoryImpl repository) {
        this.repository = repository;
    }

    /**
     * Creates a new Link Tracker link based on the provided DTO.
     *
     * @param linkTracker DTO containing information for the new Link Tracker link.
     * @return Response DTO with the result of the creation and the ID of the new link.
     */
    @Override
    public LinkTrackerResponseDTO create(LinkTrackerDTO linkTracker) {
        LinkTracker createdLink = this.repository.create(linkTracker.toEntity());
        return new LinkTrackerResponseDTO(createdLink.getId());
    }

    /**
     * Retrieves the redirect URL for a specific Link Tracker link.
     *
     * @param id       The ID of the Link Tracker link.
     * @param password Optional password for link validation.
     * @return The redirect URL if the link is valid, or an error message if not.
     * @throws LinkTrackerNotFoundException if the link is not found or the password is incorrect.
     */
    @Override
    public String getRedirectUrl(Long id, String password) {
        LinkTracker linkTracker = this.repository.getLinkTrackerById(id);
        if (linkTracker == null) {
            throw new LinkTrackerNotFoundException("La URL no existe.");
        }

        if (linkTracker.getPassword() != null && !linkTracker.getPassword().equals(password)) {
            throw new LinkTrackerNotFoundException("Contraseña incorrecta.");
        }

        linkTracker.incrementRedirectCount();
        return linkTracker.getUrl();
    }

    /**
     * Retrieves the redirect metrics for a specific Link Tracker link.
     *
     * @param id The ID of the Link Tracker link.
     * @return The number of times the link has been redirected.
     * @throws LinkTrackerNotFoundException if the link is not found.
     */
    @Override
    public int getMetrics(Long id) {
        LinkTracker linkTracker = this.repository.getLinkTrackerById(id);
        if (linkTracker == null) {
            throw new LinkTrackerNotFoundException("La URL no existe.");
        }
        return linkTracker.getRedirectCount();
    }
}