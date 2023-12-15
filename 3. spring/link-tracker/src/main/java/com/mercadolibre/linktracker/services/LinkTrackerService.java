package com.mercadolibre.linktracker.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.linktracker.dtos.requests.UrlResquestDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerIdDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerMetricsDto;
import com.mercadolibre.linktracker.dtos.responses.LinkTrackerSimpleMessageDto;
import com.mercadolibre.linktracker.entity.LinkTracker;
import com.mercadolibre.linktracker.exceptions.NotFoundException;
import com.mercadolibre.linktracker.repository.ILinkTrackerRepository;
import com.mercadolibre.linktracker.repository.LinkTrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService {

    ILinkTrackerRepository linkTrackerRepository;

    public LinkTrackerService(LinkTrackerRepository linkTrackerRepository){
        this.linkTrackerRepository = linkTrackerRepository;
    }

    public LinkTrackerIdDto create(UrlResquestDto request){
        ObjectMapper mapper = new ObjectMapper();
        LinkTracker linkTracker = mapper.convertValue(request, LinkTracker.class);
        int linkId = linkTrackerRepository.add(linkTracker);
        return new LinkTrackerIdDto(linkId);
    }

    public String redirect(int linkId,String password){
        LinkTracker linkTracker = linkTrackerRepository.getById(linkId);

        if(linkTracker == null ||
                !linkTracker.isEnable() ||
                !linkTracker.getPassword().equals(password)) {
            throw new NotFoundException("Link no disponible. Id: " + linkId);
        }

        linkTracker.incrementRedirection();
        linkTrackerRepository.update(linkTracker);
        return linkTracker.getUrl();
    }

    public LinkTrackerMetricsDto metrics(int linkId){
        LinkTracker linkTraker = linkTrackerRepository.getById(linkId);
        return new LinkTrackerMetricsDto(linkTraker.getLinkId(),linkTraker.getRedirections());
    }

    @Override
    public LinkTrackerSimpleMessageDto invalidate(int linkId) {
        LinkTracker linkTracker = linkTrackerRepository.getById(linkId);
        linkTracker.setEnable(false);
        linkTrackerRepository.update(linkTracker);
        return new LinkTrackerSimpleMessageDto("Link invalidado correctamente");
    }


}
