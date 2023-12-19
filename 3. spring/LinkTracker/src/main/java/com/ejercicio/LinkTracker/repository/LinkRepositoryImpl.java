package com.ejercicio.LinkTracker.repository;

import com.ejercicio.LinkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    Map<Integer, Link> links = new HashMap<>();
    @Override
    public Link saveLink(Link link) {
        int newKey = links.isEmpty() ? 1 : Collections.max(links.keySet()) + 1;
        link.setId(newKey);
        links.put(newKey, link);

        return link;
    }

    @Override
    public Link searchLink(int idLink) {
        Link link = links.get(idLink);
        int currentStatistics = link.getStatistics();
        link.setStatistics(currentStatistics + 1);

        return link;
    }

    @Override
    public int metricsLink(int idLink) {
        Link link = links.get(idLink);
        return link.getStatistics();
    }

    @Override
    public Boolean invalidateLink(int idLink) {
        Link link = links.get(idLink);

        Boolean currentState = link.getActive();
        link.setActive(!currentState);

        return !currentState;
    }
}
