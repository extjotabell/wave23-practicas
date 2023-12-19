package com.ejercicio.LinkTracker.service;

import com.ejercicio.LinkTracker.dto.request.RequestLinkDTO;
import com.ejercicio.LinkTracker.dto.response.ResponseLinkDTO;
import com.ejercicio.LinkTracker.entity.Link;
import com.ejercicio.LinkTracker.exception.NotFoundException;
import com.ejercicio.LinkTracker.exception.URISyntaxException;
import com.ejercicio.LinkTracker.helpers.LinkMapper;
import com.ejercicio.LinkTracker.helpers.UrlValidator;
import com.ejercicio.LinkTracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {
    ILinkRepository repository;

    public LinkServiceImpl(ILinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseLinkDTO saveLink(RequestLinkDTO linkDTO) {
        if(!UrlValidator.isValidURL(linkDTO.getLink())){
            throw new URISyntaxException("La URL ingresada no es valida.");
        }

        Link link = LinkMapper.toLink(linkDTO);
        return LinkMapper.toResponseLinkDTO(repository.saveLink(link));
    }

    @Override
    public ResponseLinkDTO searchLink(int idLink, String password) {
        Link link = repository.searchLink(idLink);

        if (password != null && !link.getPassword().equals(password) || !link.getActive()) {
            throw new NotFoundException("Link no encontrado, contraseña incorrecta o link desactivado");
        }

        return LinkMapper.toResponseLinkDTO(link);
    }

    @Override
    public int metricsLink(int idLink) {
        return repository.metricsLink(idLink);
    }

    @Override
    public Boolean invalidateLink(int idLink) {
        return repository.invalidateLink(idLink);
    }
}
