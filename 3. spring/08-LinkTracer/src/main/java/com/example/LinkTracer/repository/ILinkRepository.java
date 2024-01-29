package com.example.LinkTracer.repository;

import com.example.linkTracker.dto.LinkDTO;

public interface ILinkRepository {
    int saveLink(LinkDTO linkDTO);

    LinkDTO getLink(int id);

    boolean containLink(int id);

    void invalidateLink(int id);

}
