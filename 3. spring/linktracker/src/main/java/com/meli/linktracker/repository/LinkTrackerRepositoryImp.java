package com.meli.linktracker.repository;

import com.meli.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepositoryImp implements ILinkTrackerRepository {

    private static List<Link> links;

    public LinkTrackerRepositoryImp() {
        links = new ArrayList<>();
    }

    @Override
    public Link createLink(String linkId, String url, String password) {
        // Verificar que el linkId no exista
        for (Link link : links) {
            if (link.getLinkId().equals(linkId)) return null;
        }

        // Crear y guardar el link
        Link link = new Link(linkId, url, password);
        links.add(link);

        return link;
    }

    @Override
    public Link getLink(String linkId) {
        return links.stream()
            .filter(l -> l.getLinkId().equals(linkId))
            .findFirst()
            .orElse(null);
    }
}
