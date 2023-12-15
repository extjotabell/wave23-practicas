package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.LinkTracker;

public interface ILinkTrackerRepository {

    LinkTracker getById(int linkId);
    int add(LinkTracker linkTracker);
    void update(LinkTracker linkTracker);
}
