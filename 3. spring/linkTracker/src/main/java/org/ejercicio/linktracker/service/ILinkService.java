package org.ejercicio.linktracker.service;

import org.ejercicio.linktracker.dto.LinkDto;
import org.ejercicio.linktracker.dto.LinkIdDto;
import org.ejercicio.linktracker.entity.Link;

public interface ILinkService {

    String redirectLinkById(Integer linkId, String password);

    LinkIdDto addLink(Link link);

    LinkDto deleteLink(Integer idLink);

    LinkDto getMetricsLink(Integer linkId);
}
