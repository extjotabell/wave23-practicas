package com.mercadolibre.linkTracker.repository;

import com.mercadolibre.linkTracker.entity.LinkTracker;
import com.mercadolibre.linkTracker.exception.LinkTrackerNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {

    private final List<LinkTracker> linkTrackerList;
    private long lastId;

    public LinkTrackerRepositoryImpl(List<LinkTracker> linkTrackerList) {
        this.linkTrackerList = linkTrackerList;
        lastId = 0;
    }

    @Override
    public LinkTracker create(LinkTracker linkTracker) {
        linkTracker.setId(++lastId);
        this.linkTrackerList.add(linkTracker);
        return linkTracker;
    }

    @Override
    public LinkTracker getLinkTrackerById(Long id) {
        return this.linkTrackerList.stream()
                .filter(linkTracker -> linkTracker.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public LinkTracker deleteLinkTrackerById(Long id) {
        LinkTracker res = linkTrackerList.stream().filter(linkTracker -> linkTracker.getId().equals(id)).findFirst().orElse(null);
        if(res != null){
            linkTrackerList.remove(res);
        }
        return res;
    }


}
