package meli.bootcamp.spring.learning.ej11.service;

import java.util.Optional;

import meli.bootcamp.spring.learning.ej11.dto.MessageDto;
import meli.bootcamp.spring.learning.ej11.dto.request.InvalidateLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.request.NewLinkRequestDto;
import meli.bootcamp.spring.learning.ej11.dto.response.LinkMetricsDto;
import meli.bootcamp.spring.learning.ej11.dto.response.NewLinkResponseDto;

public interface ILinkService {
  NewLinkResponseDto save(NewLinkRequestDto newLink);

  String redirect(int linkId, Optional<String> password);

  LinkMetricsDto getMetrics(int linkId);

  MessageDto invalidateLink(InvalidateLinkRequestDto invalidateLinkDto);
}
