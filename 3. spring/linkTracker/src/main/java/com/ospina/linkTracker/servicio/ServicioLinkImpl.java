package com.ospina.linkTracker.servicio;

import com.ospina.linkTracker.excepcion.LinkNoEncontradoExcepcion;
import com.ospina.linkTracker.modelo.dto.LinkDTO;
import com.ospina.linkTracker.repositorio.RepositorioLink;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicioLinkImpl implements ServicioLink{
    private final RepositorioLink repositorioLink;

    public ServicioLinkImpl(RepositorioLink repositorioLink) {
        this.repositorioLink = repositorioLink;
    }

    @Override
    public int crearLink(String url, String password) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("La URL no puede ser nula o vacía");
        }
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setOriginalURL(url);
        linkDTO.setPassword(password);
        linkDTO.setValid(true);
        return repositorioLink.guardarLink(linkDTO);
    }

    @Override
    public String redireccionarLink(int id, String password) {
        LinkDTO linkDTO = repositorioLink.obtenerLink(id);
        validateLink(linkDTO, password);
        linkDTO.setRedirectCount(linkDTO.getRedirectCount() + 1);
        return linkDTO.getOriginalURL();
    }

    private void validateLink(LinkDTO linkDTO, String password) {
        if (linkDTO == null || !linkDTO.isValid() || !linkDTO.getPassword().equals(password)) {
            throw new LinkNoEncontradoExcepcion();
        }
    }

    @Override
    public Map<String, Integer> obtenerEstadisticas(int id) {
        LinkDTO linkDTO = repositorioLink.obtenerLink(id);
        if (linkDTO == null) {
            throw new LinkNoEncontradoExcepcion();
        }
        return Map.of("redirectCount", linkDTO.getRedirectCount());
    }

    @Override
    public void invalidarLink(int id) {
        if (!repositorioLink.contieneLink(id)) {
            throw new LinkNoEncontradoExcepcion();
        }
        repositorioLink.invalidarLink(id);
    }
}
