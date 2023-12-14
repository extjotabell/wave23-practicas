package org.ejercicio.linktracker.repository;

import org.ejercicio.linktracker.dto.LinkDto;
import org.ejercicio.linktracker.entity.Link;

public interface ILinkRepository {

    Link getById(Integer id);

    Integer addLink(Link link);

    Link deleteLink(Integer idLink);

    Link getMetricsLink(Integer linkId);
}
