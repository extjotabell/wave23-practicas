package org.ejercicio.linktracker.service;

import org.ejercicio.linktracker.dto.LinkDto;
import org.ejercicio.linktracker.dto.LinkIdDto;
import org.ejercicio.linktracker.entity.Link;
import org.ejercicio.linktracker.exception.LinkAlreadyExistException;
import org.ejercicio.linktracker.exception.LinkInactiveException;
import org.ejercicio.linktracker.exception.LinkInvalidPasswordException;
import org.ejercicio.linktracker.exception.LinkNotFoundException;
import org.ejercicio.linktracker.repository.ILinkRepository;
import org.ejercicio.linktracker.repository.LinkRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkServiceImpl(LinkRepositoryImpl linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public String redirectLinkById(Integer linkId, String password) {
        Link link = this.linkRepository.getById(linkId);
        if (link == null) {
            throw new LinkNotFoundException("La URL con ID: " + linkId + " no se encuentra.");
        }
        if (!link.getPassword().equals(password)) {
            throw new LinkInvalidPasswordException("La contraseña de la URL es incorrecta.");
        }
        if (!link.getActive()) {
            throw new LinkInactiveException("La URL está desactivada.");
        }
        link.setCalls(link.getCalls() + 1);
        return link.getUrl();
    }

    @Override
    public LinkIdDto addLink(Link link) {
        if (this.linkRepository.getById(link.getId()) != null) {
            throw new LinkAlreadyExistException("La URL con ID: " + link.getId() + " ya existe.");
        }
        link.setCalls(0);
        this.linkRepository.addLink(link);
        return new LinkIdDto(this.linkRepository.addLink(link));
    }

    @Override
    public LinkDto deleteLink(Integer linkId) {
        Link linkDeleted = this.linkRepository.deleteLink(linkId);
        if (linkDeleted == null) {
            throw new LinkNotFoundException("La URL con ID: " + linkId + " no se encuentra.");
        }
        return new LinkDto(linkDeleted.getUrl(), linkDeleted.getCalls(), linkDeleted.getActive());
    }

    @Override
    public LinkDto getMetricsLink(Integer linkId) {
        Link linkFinded = this.linkRepository.getMetricsLink(linkId);
        if (linkFinded == null) {
            throw new LinkNotFoundException("La URL con ID: " + linkId + " no se encuentra.");
        }
        return new LinkDto(linkFinded.getUrl(), linkFinded.getCalls(), linkFinded.getActive());
    }
}
