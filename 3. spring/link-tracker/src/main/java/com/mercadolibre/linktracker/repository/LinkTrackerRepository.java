package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.LinkTracker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{

    private ArrayList<LinkTracker> links = new ArrayList<>();

    @Override
    public LinkTracker getById(int linkId) {
        return links.stream()
                .filter(l -> l.getLinkId() == linkId)
                .findFirst().orElse(null);
    }

    public int add(LinkTracker linkTracker){
        int linkId = links.size()+1;
        linkTracker.setLinkId(linkId);
        links.add(linkTracker);
        return linkId;
    }

    public void update(LinkTracker linkTracker){
        int index = links.indexOf(linkTracker);
        links.set(index,linkTracker);
    }
}
