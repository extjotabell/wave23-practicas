package com.ospina.linkTracker.repositorio;

import com.ospina.linkTracker.modelo.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositorioLinkImpl implements RepositorioLink{

    private final Map<Integer, LinkDTO> linkData = new HashMap<>();
    private int linkIdCounter = 1;

    @Override
    public int guardarLink(LinkDTO linkDTO) {
        linkData.put(linkIdCounter, linkDTO);
        linkIdCounter++;
        return linkIdCounter - 1;
    }

    @Override
    public LinkDTO obtenerLink(int id) {
        return linkData.get(id);
    }

    @Override
    public boolean contieneLink(int id) {
        return linkData.containsKey(id);
    }

    @Override
    public void invalidarLink(int id) {
        linkData.get(id).setValid(false);
    }
}
