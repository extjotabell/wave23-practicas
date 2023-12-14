package org.ejercicio.linktracker.repository;

import org.ejercicio.linktracker.dto.LinkDto;
import org.ejercicio.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<Link> links = new ArrayList<>();

    @Override
    public Link getById(Integer id) {
        return this.links.stream().filter(link -> link.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Integer addLink(Link link) {
        this.links.add(link);
        return link.getId();
    }

    @Override
    public Link deleteLink(Integer idLink) {
        Link linkToDesactivate = this.getById(idLink);
        linkToDesactivate.setActive(false);
        return linkToDesactivate;
    }

    @Override
    public Link getMetricsLink(Integer linkId) {
        return getById(linkId);
    }
}
