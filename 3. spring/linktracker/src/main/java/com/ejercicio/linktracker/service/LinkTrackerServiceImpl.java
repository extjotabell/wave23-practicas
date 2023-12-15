package com.ejercicio.linktracker.service;

import com.ejercicio.linktracker.dto.request.RequestLinkDto;
import com.ejercicio.linktracker.dto.response.ResponseCreatedLinkDto;
import com.ejercicio.linktracker.dto.response.ResponseInvalidateLinkDto;
import com.ejercicio.linktracker.dto.response.ResponseRedirectNumberDto;
import com.ejercicio.linktracker.entity.Link;
import com.ejercicio.linktracker.exception.NotFoundException;
import com.ejercicio.linktracker.repository.ILinkTrackerRepository;
import com.ejercicio.linktracker.repository.LinkTrackerRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;

import java.net.URI;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {

    ILinkTrackerRepository repository;
    public LinkTrackerServiceImpl(LinkTrackerRepositoryImpl repository) {
        this.repository = repository;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponseCreatedLinkDto createLink(RequestLinkDto urlDto) {
        Link link = mapper.convertValue(urlDto, Link.class);
        repository.createLink(link);
        return new ResponseCreatedLinkDto(link.getId());
    }

    @Override
    public HttpHeaders redirect(Integer linkid) {
        if (!repository.validateLink(linkid)) {
            throw new NotFoundException("La URL no es válida");
        }

        Link link = repository.getLink(linkid);
        repository.increaseRedirec(linkid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(link.getUrl()));
        return httpHeaders;
    }

    @Override
    public ResponseRedirectNumberDto returnRedirecNumber(Integer linkid) {
        return new ResponseRedirectNumberDto(repository.getLink(linkid).getNroRedirecciones());
    }

    @Override
    public ResponseInvalidateLinkDto invalidateLink(Integer linkid) {
        if (!repository.validateLink(linkid)) {
            throw new NotFoundException("La URL no es válida");
        }

        repository.getLink(linkid).setValid(false);
        return new ResponseInvalidateLinkDto("La URL se ha invalidado");
    }
}
