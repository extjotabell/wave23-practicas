package com.spring.linktracker.service;

import com.spring.linktracker.dto.request.LinkRequestDto;
import com.spring.linktracker.dto.response.LinkResponseDto;
import com.spring.linktracker.dto.response.MetricResponseDto;
import com.spring.linktracker.dto.response.UrlResponseDto;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.exception.LinkInactiveException;
import com.spring.linktracker.exception.NotFoundException;
import com.spring.linktracker.exception.PasswordInvalidException;
import com.spring.linktracker.repository.interfaces.ILinkRepository;
import com.spring.linktracker.service.interfaces.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    private ILinkRepository _repository;

    @Override
    public LinkResponseDto createLink(LinkRequestDto link) {
       int linkId = _repository.createLink(new Link(link.getUrl(), link.getPassword()));

       return new LinkResponseDto(linkId);
    }

    @Override
    public MetricResponseDto metrics(int linkId) {
        int count = _repository.findLinkById(linkId).getCountRedirect();
        return new MetricResponseDto(count);
    }

    @Override
    public UrlResponseDto redirect(int linkId, String password) {
        Link link = _repository.findLinkById(linkId);
        if (link == null) {
            throw new NotFoundException("Link no encontrado");
        }
        System.out.println(link.getPassword());
        if(!link.getPassword().equals(password)){
            throw new PasswordInvalidException("Contraseña invalida");
        }
        if(!link.isValid()){
            throw new LinkInactiveException("El link esta desactivado");
        }
            link.incrementCountRedirect();
            return new UrlResponseDto(link.getUrl());
    }

    @Override
    public String deleteLink(int idLink) {
        _repository.deleteLink(idLink);
        return "El link se ha desactivado";
    }
}
