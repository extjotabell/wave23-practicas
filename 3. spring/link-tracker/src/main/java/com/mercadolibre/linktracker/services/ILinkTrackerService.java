package com.mercadolibre.linktracker.services;

import com.mercadolibre.linktracker.dtos.requests.UrlResquestDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerIdDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerMetricsDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerSimpleMessageDto;

public interface ILinkTrackerService {
    LinkTrackerIdDto create(UrlResquestDto request);
    String redirect(int linkId,String password);

    LinkTrackerMetricsDto metrics(int linkId);

    LinkTrackerSimpleMessageDto invalidate(int linkId);
}
