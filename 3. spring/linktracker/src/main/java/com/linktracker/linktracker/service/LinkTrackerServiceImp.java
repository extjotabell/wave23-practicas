package com.linktracker.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linktracker.linktracker.dto.Request.URLDTO;
import com.linktracker.linktracker.dto.Response.LinkIDDTO;
import com.linktracker.linktracker.entity.URL;
import com.linktracker.linktracker.exception.NotFoundException;
import com.linktracker.linktracker.repository.ILinkTrackerRepository;
import com.linktracker.linktracker.repository.LinkTrackerRepositoryImp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LinkTrackerServiceImp implements ILinkTrackerService{

    private ObjectMapper mapper = new ObjectMapper();
    private ILinkTrackerRepository repositoryImp;

    public LinkTrackerServiceImp (LinkTrackerRepositoryImp repositoryImp) {
        this.repositoryImp = repositoryImp;
    }
    @Override
    public LinkIDDTO crearLink(URLDTO urldto) {
        URL url = mapper.convertValue(urldto, URL.class);
        repositoryImp.agregarURL(url);
        return new LinkIDDTO(url.getId());
    }

    @Override
    public HttpHeaders crearRedireccion(Integer linkid) {
        if (!repositoryImp.validarURL(linkid)) throw new NotFoundException("El link no es vàlido");
        URL url = repositoryImp.conseguirURL(linkid);
        repositoryImp.incrementarContadorRedirecciones(linkid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(url.getUrl()));
        return httpHeaders;
    }

    @Override
    public Integer retornarNumeroRedirecciones(Integer linkid) {
        if (!repositoryImp.validarURL(linkid)) throw new NotFoundException("El link no es vàlido");
        URL url = repositoryImp.conseguirURL(linkid);
        return url.getNumeroRedirecciones();
    }

    @Override
    public void invalidarLink(Integer linkid) {
        if (!repositoryImp.validarURL(linkid)) throw new NotFoundException("El link no es vàlido");
        URL url = repositoryImp.conseguirURL(linkid);
        url.setValido(false);
    }

}
