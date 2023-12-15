package com.mercadolibre.linkTracker.dto.request;

import com.mercadolibre.linkTracker.entity.LinkTracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing the request for creating a new Link Tracker link.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerDTO {
    /**
     * The URL for the new Link Tracker link.
     */
    private String url;
    /**
     * Optional password for securing the link. Can be null if no password is provided.
     */
    private String password;

    /**
     * Converts the LinkTrackerDTO to its corresponding entity representation.
     *
     * @return LinkTracker entity with the information from the DTO.
     */
    public LinkTracker toEntity(){
        return new LinkTracker(
                null,
                url,
                password
        );
    }
}
