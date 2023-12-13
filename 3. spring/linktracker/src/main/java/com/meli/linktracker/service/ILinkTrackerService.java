package com.meli.linktracker.service;

import com.meli.linktracker.dto.request.CreateLinkRequestDto;
import com.meli.linktracker.dto.response.CreateLinkResponseDto;
import com.meli.linktracker.dto.response.InvalidateDto;
import com.meli.linktracker.dto.response.MetricsDto;
import com.meli.linktracker.dto.response.RedirectDto;

public interface ILinkTrackerService {

    CreateLinkResponseDto createLink(String linkId, CreateLinkRequestDto createLinkRequestDto);

    RedirectDto getLink(String linkId, String password);

    MetricsDto getMetrics(String linkId);

    InvalidateDto invalidateLink(String linkId);
}
