package com.ejercicio.linktracker.repository;

import com.ejercicio.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {

    private List<Link> links = new ArrayList<>();

    @Override
    public Integer createLink(Link link) {
        link.setId(links.size() + 1);
        link.setNroRedirecciones(0);
        link.setValid(true);
        links.add(link);
        return link.getId();
    }

    @Override
    public Boolean validateLink(Integer idlink) {
        return links.stream().anyMatch(l -> l.getId().equals(idlink) && l.getValid());
    }

    @Override
    public Link getLink(Integer idlink) {
        return links.stream().filter(l -> l.getId().equals(idlink)).findFirst().get();
    }

    @Override
    public void increaseRedirec(Integer idlink) {
        Link link = getLink(idlink);
        link.setNroRedirecciones(link.getNroRedirecciones() + 1);
    }

}
