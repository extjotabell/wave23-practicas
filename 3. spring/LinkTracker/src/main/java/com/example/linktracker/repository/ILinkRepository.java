package com.example.linktracker.repository;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.entity.Link;

public interface ILinkRepository {
    Link getById(Long id);

    Long addLink(Link link);

    void deleteLink(Long idLink);

}
