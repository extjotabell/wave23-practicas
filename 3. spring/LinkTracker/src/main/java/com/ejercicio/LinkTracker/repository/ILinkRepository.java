package com.ejercicio.LinkTracker.repository;

import com.ejercicio.LinkTracker.entity.Link;

public interface ILinkRepository {
    Link saveLink (Link link);
    Link searchLink (int idLink);
    int metricsLink (int idLink);
    Boolean invalidateLink (int idLink);
}
