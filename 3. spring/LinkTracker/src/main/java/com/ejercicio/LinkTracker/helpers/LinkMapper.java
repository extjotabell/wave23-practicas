package com.ejercicio.LinkTracker.helpers;

import com.ejercicio.LinkTracker.dto.request.RequestLinkDTO;
import com.ejercicio.LinkTracker.dto.response.ResponseLinkDTO;
import com.ejercicio.LinkTracker.entity.Link;

public class LinkMapper {
    public static Link toLink(RequestLinkDTO dto) {
        Link link = new Link();
        link.setLink(dto.getLink());
        link.setActive(true);
        link.setStatistics(0);

        return link;
    }

    public static ResponseLinkDTO toResponseLinkDTO (Link link){
        ResponseLinkDTO dto = new ResponseLinkDTO();
        dto.setLink(link.getLink());
        dto.setActive(link.getActive());
        dto.setId(link.getId());
        dto.setStatistic(link.getStatistics());

        return dto;
    }
}
