package com.spring.linktracker.repository.interfaces;

import com.spring.linktracker.entity.Link;

public interface ILinkRepository {

    int createLink(Link link);

    Link findLinkById(int id);

    void deleteLink(int idLink);
}
