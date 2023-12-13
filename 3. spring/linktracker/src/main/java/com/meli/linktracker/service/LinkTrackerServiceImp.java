package com.meli.linktracker.service;

import com.meli.linktracker.dto.request.CreateLinkRequestDto;
import com.meli.linktracker.dto.response.CreateLinkResponseDto;
import com.meli.linktracker.dto.response.InvalidateDto;
import com.meli.linktracker.dto.response.MetricsDto;
import com.meli.linktracker.dto.response.RedirectDto;
import com.meli.linktracker.entity.Link;
import com.meli.linktracker.exception.*;
import com.meli.linktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerServiceImp implements ILinkTrackerService {

    @Autowired
    private ILinkTrackerRepository repository;

    @Override
    public CreateLinkResponseDto createLink(String linkId, CreateLinkRequestDto createLinkRequestDto) {
        // Validate if url starts with "http://" or "https://"
        String url = createLinkRequestDto.getUrl();

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new InvalidURLException("Invalid url, it must start with \"http://\" or \"https://\"");
        }

        Link link = repository.createLink(
            linkId,
            createLinkRequestDto.getUrl(),
            createLinkRequestDto.getPassword()
        );

        // Verificar que el linkId no exista
        if (link == null) throw new LinkAlreadyExistsException("Link already exists");

        return new CreateLinkResponseDto(
            link.getLinkId(),
            link.getUrl(),
            link.getPassword(),
            link.getRedirectCount(),
            link.isValid()
        );
    }

    @Override
    public RedirectDto getLink(String linkId, String password) {
        Link link = repository.getLink(linkId);

        // Verificar que el linkId exista
        if (link == null) throw new InexistentLinkException("Link does not exist");

        // Verificar que el link no esté invalidado
        if (!link.isValid()) throw new InvalidLinkException("Link is invalid");

        // Verificar la contraseña
        if (!link.getPassword().equals(password)) throw new IncorrectPasswordException("Invalid password");

        // Incrementar el contador de redirecciones
        link.setRedirectCount(link.getRedirectCount() + 1);

        return new RedirectDto(link.getUrl());
    }

    @Override
    public MetricsDto getMetrics(String linkId) {
        Link link = repository.getLink(linkId);

        // Verificar que el linkId exista
        if (link == null) throw new InexistentLinkException("Link does not exist");

        return new MetricsDto(link.getRedirectCount());
    }

    @Override
    public InvalidateDto invalidateLink(String linkId) {
        Link link = repository.getLink(linkId);

        // Verificar que el linkId exista
        if (link == null) throw new InexistentLinkException("Link does not exist");

        // Verificar que el link no esté invalidado
        if (!link.isValid()) throw new InvalidLinkException("Link is already invalid");

        // Invalidar el link
        link.setValid(false);

        return new InvalidateDto(link.isValid());
    }
}
