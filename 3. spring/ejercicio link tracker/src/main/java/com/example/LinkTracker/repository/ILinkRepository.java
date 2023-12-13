package com.example.LinkTracker.repository;

import com.example.LinkTracker.dto.LinkDto;
import com.example.LinkTracker.entity.Link;

public interface ILinkRepository {

    void save(Link newLink);
    Link findById(int id);
    int returnCounter(String linkId);
    void invalidateLink(String linkId);

}
