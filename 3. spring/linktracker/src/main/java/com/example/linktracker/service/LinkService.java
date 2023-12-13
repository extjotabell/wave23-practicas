package com.example.linktracker.service;

import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkMetricaDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.LinkInactiveException;
import com.example.linktracker.exception.LinkInvalidPasswordException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public String redirectLinkById(Long id, String password) {
        Link link = linkRepository.getById(id);
        if (link == null) {
            throw new LinkNotFoundException(id);
        }
        if(!link.getPassword().equals(password)){
            throw new LinkInvalidPasswordException();
        }
        if(!link.isActivo()){
            throw new LinkInactiveException(id);
        }
        link.incrementarLlamados();
        return link.getUrl();
    }


    @Override
    public LinkIdDTO addLink(Link link) {
        return new LinkIdDTO(linkRepository.addLink(link));
    }

    @Override
    public String deleteLink(Long idLink) {
        linkRepository.deleteLink(idLink);
        return "El link se ha desactivado";
    }

    @Override
    public LinkMetricaDTO getMetricaLink(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Link link = linkRepository.getById(id);
        if (link == null) {
            throw new LinkNotFoundException(id);
        }
        return new LinkMetricaDTO(link.getLlamadas());
    }
}
