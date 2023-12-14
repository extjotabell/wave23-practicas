package meli.bootcamp.spring.learning.ej11.service;

import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej11.dto.MessageDto;
import meli.bootcamp.spring.learning.ej11.dto.request.InvalidateLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.request.NewLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.response.LinkMetricsDto;
import meli.bootcamp.spring.learning.ej11.dto.response.NewLinkResponseDto;
import meli.bootcamp.spring.learning.ej11.entity.Link;
import meli.bootcamp.spring.learning.ej11.exception.InvalidParamsException;
import meli.bootcamp.spring.learning.ej11.exception.InvalidURLException;
import meli.bootcamp.spring.learning.ej11.repository.ILinkRepository;
import meli.bootcamp.spring.learning.ej11.repository.LinkRepositoryImpl;
import meli.bootcamp.spring.learning.ej11.util.PasswordGenerator;
import meli.bootcamp.spring.learning.ej11.util.URLValidator;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {

  private ILinkRepository iLinkRepository;

  public LinkServiceImpl(LinkRepositoryImpl linkRepositoryImpl) {
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

    if (linkId < 0 || password.isEmpty()) {
      throw new InvalidParamsException("Invalid information");
    }

    Link foundLink = this.iLinkRepository.findById(linkId);
    if (foundLink == null || !foundLink.isValid() || !foundLink.getPassword().equals(password.get())) {
      throw new InvalidURLException("Invalid URL");
    }
    foundLink.incrementCounter();
    return foundLink.getUrl();
  }

  @Override
  public LinkMetricsDto getMetrics(int linkId) {
    Link foundLink = this.iLinkRepository.findById(linkId);
    if (foundLink == null) {
      throw new InvalidURLException("Invalid URL");
    }
    return new LinkMetricsDto(foundLink.getCounter());
  }

  @Override
  public MessageDto invalidateLink(InvalidateLinkRequestDto invalidateLinkDto) {
    Link foundLink = this.iLinkRepository.findById(invalidateLinkDto.getId());
    if (foundLink == null) {
      throw new InvalidURLException("Invalid URL");
    }
    foundLink.setValid(false);
    return new MessageDto("Link invalidated");
  }
}
