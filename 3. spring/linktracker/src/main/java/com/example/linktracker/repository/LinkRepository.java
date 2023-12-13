package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{
    private final Map<Long, Link> links;
    private static Long count=0L;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    @Override
    public Link getById(Long id) {
        return links.get(id);
    }

    @Override
    public Long addLink(Link link) {
        Long id=count++;
        links.put(id,link);
        return id;
    }

    @Override
    public void deleteLink(Long linkId) {
        Link link = getById(linkId);
        link.setActivo(false);
    }
}
