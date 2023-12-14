package com.spring.linktracker.repository;

import com.spring.linktracker.entity.Link;
import com.spring.linktracker.exception.NotFoundException;
import com.spring.linktracker.repository.interfaces.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    List<Link> links = new ArrayList<>();

    @Override
    public int createLink(Link link) {
        links.add(link);
        return link.getLinkId();
    }

    @Override
    public Link findLinkById(int id) {
        return links
                .stream()
                .filter(x -> x.getLinkId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteLink(int idLink) {
        Link link = findLinkById(idLink);
        if(link == null)
            throw new NotFoundException("El link con el id " + idLink + " no existe");

        link.setValid(false);
    }


}
