package com.mercadolibre.linkTracker.repository;

import com.mercadolibre.linkTracker.entity.LinkTracker;

public interface ILinkTrackerRepository {
    LinkTracker create(LinkTracker linkTracker);
    LinkTracker getLinkTrackerById(Long id);
    LinkTracker deleteLinkTrackerById(Long id);
}
