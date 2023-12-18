package com.mercadolibre.linkTracker.service;

import com.mercadolibre.linkTracker.dto.request.LinkTrackerDTO;
import com.mercadolibre.linkTracker.dto.response.LinkTrackerResponseDTO;
import com.mercadolibre.linkTracker.entity.LinkTracker;
import com.mercadolibre.linkTracker.exception.LinkTrackerNotFoundException;
import com.mercadolibre.linkTracker.repository.ILinkTrackerRepository;
import com.mercadolibre.linkTracker.repository.LinkTrackerRepositoryImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService{

    ILinkTrackerRepository repository;
    private Integer redirect;

    public LinkTrackerServiceImpl(LinkTrackerRepositoryImpl repository){
        this.repository = repository;
        this.redirect = 0;
    }

    @Override
    public LinkTrackerResponseDTO create(LinkTrackerDTO linkTracker) {
        LinkTracker linkTracker1 = this.repository.create(linkTracker.toEntity());
        return new LinkTrackerResponseDTO(linkTracker1.getId());
    }

    @Override
    public String getRedirectUrl(Long id) {
        LinkTracker linkTracker = this.repository.getLinkTrackerById(id);
        if(linkTracker == null){
            throw new LinkTrackerNotFoundException("La URL no existe.");
        }
        redirect++;
        return linkTracker.getUrl();
    }

    @Override
    public int getMetrics() {
        return redirect;
    }

}
