package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.MessageDto;
import com.example.LinkTracker.dto.request.InvalidateLinkRequestDto;
import com.example.LinkTracker.dto.request.NewLinkRequestDto;
import com.example.LinkTracker.dto.response.LinkMetricsDto;
import com.example.LinkTracker.dto.response.NewLinkResponseDto;

import java.util.Optional;

public interface ILinkService {
    NewLinkResponseDto save(NewLinkRequestDto newLink);
    String redirect(int linkId, Optional<String> password);
    LinkMetricsDto getMetrics(int linkId);
    MessageDto invalidateLink(InvalidateLinkRequestDto invalidateLinkDto);
}
