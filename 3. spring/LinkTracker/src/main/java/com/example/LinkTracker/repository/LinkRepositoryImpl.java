package com.example.LinkTracker.repository;

import com.example.LinkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    List<Link> linksList = new ArrayList<>();

    @Override
    public void save(Link newLink) {
        linksList.add(newLink);
    }

    @Override
    public Link findById(int id) {
        return linksList.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int returnCounter(String linkId) {
        return 0;
    }

    @Override
    public void invalidateLink(String linkId) {

    }
}
