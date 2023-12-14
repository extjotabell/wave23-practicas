package com.ejLinkTracker.ejLinkTracker.service;

import com.ejLinkTracker.ejLinkTracker.dto.request.LinkTrackerDTO;
import com.ejLinkTracker.ejLinkTracker.dto.response.LinkTrackerCreatedResponseDTO;
import com.ejLinkTracker.ejLinkTracker.dto.response.LinkTrackerResponseDTO;
import com.ejLinkTracker.ejLinkTracker.entity.LinkTracker;
import com.ejLinkTracker.ejLinkTracker.exception.LinkTrackerNotFoundException;
import com.ejLinkTracker.ejLinkTracker.repository.ILinkTrackerRepository;
import com.ejLinkTracker.ejLinkTracker.repository.LinkTrackerRepositoryImpl;
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
    public LinkTrackerCreatedResponseDTO create(LinkTrackerDTO linkTracker) {
        LinkTracker linkTracke1 = this.repository.create(linkTracker.toEntity());
        return new LinkTrackerCreatedResponseDTO(linkTracke1.getId());
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
