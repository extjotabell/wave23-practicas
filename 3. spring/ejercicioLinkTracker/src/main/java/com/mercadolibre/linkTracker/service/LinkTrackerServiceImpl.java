package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerCreatedResponseDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;
import com.mercadolibre.linkTracker.exception.LinkTrackerNotFoundException;
import com.mercadolibre.linkTracker.repository.ILinkTrackerRepository;
import com.mercadolibre.linkTracker.repository.LinkTrackerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService{

    ILinkTrackerRepository repository;

    public LinkTrackerServiceImpl(LinkTrackerRepositoryImpl repository){
        this.repository = repository;
    }

    @Override
    public LinkTrackerCreatedResponseDTO create(LinkTrackerDTO linkTracker) {
        LinkTracker linkTracker1 = this.repository.create(linkTracker.toEntity());
        return new LinkTrackerCreatedResponseDTO(linkTracker1.getId());
    }

    @Override
    public String getRedirectUrl(Long id) {
        LinkTracker linkTracker = this.repository.getLinkTrackerById(id);
        if(linkTracker == null){
            throw new LinkTrackerNotFoundException("La URL no existe.");
        }
        linkTracker.increaseRedirectCount();
        return linkTracker.getUrl();
    }

    @Override
    public int getMetrics(Long linkId) {
        LinkTracker linkTracker = this.repository.getLinkTrackerById(linkId);
        if(linkTracker == null){
            throw new LinkTrackerNotFoundException("La URL no existe.");
        }
        return linkTracker.getRedirectCount();
    }

    @Override
    public LinkTrackerResponseDTO invalidate(Long linkId) {
        LinkTracker res = repository.deleteLinkTrackerById(linkId);
        if(res == null){
            throw new LinkTrackerNotFoundException("No existe un linkTracker con ese ID");
        }
        return new LinkTrackerResponseDTO(
                res.getUrl(),
                res.getPassword(),
                res.getRedirectCount()
        );
    }

}
