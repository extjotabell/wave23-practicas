package com.ejercicio.linktracker.repository;

import com.ejercicio.linktracker.entity.Link;

public interface ILinkTrackerRepository {

    Integer createLink(Link link);

    Boolean validateLink(Integer idlink);

    Link getLink(Integer idlink);

    void increaseRedirec (Integer idlink);
}
