package com.ejLinkTracker.ejLinkTracker.repository;

import com.ejLinkTracker.ejLinkTracker.entity.LinkTracker;

public interface ILinkTrackerRepository {
    LinkTracker create(LinkTracker linkTracker);
    LinkTracker getLinkTrackerById(Long id);
    LinkTracker deleteLinkTrackerById(Long id);
}
