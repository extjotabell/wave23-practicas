package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.MessageDto;
import com.example.LinkTracker.dto.request.InvalidateLinkRequestDto;
import com.example.LinkTracker.dto.request.NewLinkRequestDto;
import com.example.LinkTracker.dto.response.LinkMetricsDto;
import com.example.LinkTracker.dto.response.NewLinkResponseDto;
import com.example.LinkTracker.entity.Link;
import com.example.LinkTracker.exception.InvalidParamsException;
import com.example.LinkTracker.exception.InvalidURLException;
import com.example.LinkTracker.repository.ILinkRepository;
import com.example.LinkTracker.repository.LinkRepositoryImpl;
import com.example.LinkTracker.util.PasswordGenerator;
import com.example.LinkTracker.util.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {

    private ILinkRepository iLinkRepository;

    public LinkServiceImpl(LinkRepositoryImpl linkRepositoryImpl){
        this.iLinkRepository = linkRepositoryImpl;
    }

    @Override
    public NewLinkResponseDto save(NewLinkRequestDto newLink) {

        URLValidator urlValidator = new URLValidator();
        urlValidator.validateURL(newLink.getUrl());
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        Link link = new Link(newLink.getUrl(), passwordGenerator.generatePassword());
        this.iLinkRepository.save(link);
        return new NewLinkResponseDto(link.getId(), link.getPassword());
    }

    @Override
    public String redirect(int linkId, Optional<String> password) {

        if(linkId < 0 || password.isEmpty()){
            throw new InvalidParamsException("Invalid information");
        }

        Link foundLink = this.iLinkRepository.findById(linkId);
        if(foundLink == null || !foundLink.isValid() || !foundLink.getPassword().equals(password.get())){
            throw new InvalidURLException("Invalid URL");
        }
        foundLink.incrementCounter();
        return foundLink.getUrl();
    }

    @Override
    public LinkMetricsDto getMetrics(int linkId) {
        Link foundLink = this.iLinkRepository.findById(linkId);
        if(foundLink == null){
            throw new InvalidURLException("Invalid URL");
        }
        return new LinkMetricsDto(foundLink.getCounter());
    }

    @Override
    public MessageDto invalidateLink(InvalidateLinkRequestDto invalidateLinkDto) {
        Link foundLink = this.iLinkRepository.findById(invalidateLinkDto.getId());
        if(foundLink == null){
            throw new InvalidURLException("Invalid URL");
        }
        foundLink.setValid(false);
        return new MessageDto("Link invalidated");
    }
}
