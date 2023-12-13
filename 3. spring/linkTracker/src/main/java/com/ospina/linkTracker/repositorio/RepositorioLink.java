package com.ospina.linkTracker.repositorio;

import com.ospina.linkTracker.modelo.dto.LinkDTO;

public interface RepositorioLink {

    int guardarLink(LinkDTO linkDTO);

    LinkDTO obtenerLink(int id);

    boolean contieneLink(int id);

    void invalidarLink(int id);
}
