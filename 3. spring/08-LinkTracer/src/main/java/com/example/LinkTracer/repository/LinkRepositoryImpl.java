package com.example.LinkTracer.repository;

import com.example.linkTracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private final Map<Integer, LinkDTO> linkData = new HashMap<>();
    private int linkIdCounter = 1;
    @Override
    public int saveLink(LinkDTO linkDTO) {
        linkData.put(linkIdCounter, linkDTO);
        linkIdCounter++;
        return linkIdCounter - 1;
    }

    @Override
    public LinkDTO getLink(int id) {
        return linkData.get(id);
    }

    @Override
    public boolean containLink(int id) {
        return linkData.containsKey(id);
    }

    @Override
    public void invalidateLink(int id) {
        linkData.get(id).setValid(false);
    }
}
