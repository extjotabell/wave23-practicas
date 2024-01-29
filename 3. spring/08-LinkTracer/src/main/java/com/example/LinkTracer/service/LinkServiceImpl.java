package com.example.LinkTracer.service;

import com.example.linkTracker.dto.LinkDTO;
import com.example.linkTracker.exception.LinkNotFoundException;
import com.example.linkTracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LinkServiceImpl implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    @Override
    public int createlink(String url, String password) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("La URL no puede ser nula o vacía");
        }
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setOriginalURL(url);
        linkDTO.setPassword(password);
        linkDTO.setValid(true);
        return linkRepository.saveLink(linkDTO);
    }

    @Override
    public String redirectLink(int linkId, String password) {
        LinkDTO linkDTO = linkRepository.getLink(linkId);
        validateLink(linkDTO, password);
        linkDTO.setRedirectCount(linkDTO.getRedirectCount() + 1);
        return linkDTO.getOriginalURL();
    }

    private void validateLink(LinkDTO linkDTO, String password) {
        if (linkDTO == null || !linkDTO.isValid() || !linkDTO.getPassword().equals(password)) {
            throw new LinkNotFoundException();
        }
    }


    @Override
    public void invalidateLink(int linkId) {
        if (!linkRepository.containLink(linkId)) {
            throw new LinkNotFoundException();
        }
        linkRepository.invalidateLink(linkId);
    }

    @Override
    public Map<String, Integer> getStadistics(int linkId) {
        LinkDTO linkDTO = linkRepository.getLink(linkId);
        if (linkDTO == null) {
            throw new LinkNotFoundException();
        }
        return Map.of("redirectCount", linkDTO.getRedirectCount());
    }
}
