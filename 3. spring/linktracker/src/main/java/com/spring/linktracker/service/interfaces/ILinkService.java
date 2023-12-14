package com.spring.linktracker.service.interfaces;

import com.spring.linktracker.dto.request.LinkRequestDto;
import com.spring.linktracker.dto.response.LinkResponseDto;
import com.spring.linktracker.dto.response.MetricResponseDto;
import com.spring.linktracker.dto.response.UrlResponseDto;
import com.spring.linktracker.entity.Link;

public interface ILinkService {
    LinkResponseDto createLink(LinkRequestDto link);
    MetricResponseDto metrics(int linkId);
    UrlResponseDto redirect(int linkId, String password);
    String deleteLink(int idLink);
}
