package com.ejercicio.LinkTracker.service;

import com.ejercicio.LinkTracker.dto.request.RequestLinkDTO;
import com.ejercicio.LinkTracker.dto.response.ResponseLinkDTO;
import com.ejercicio.LinkTracker.entity.Link;

public interface ILinkService {
    ResponseLinkDTO saveLink (RequestLinkDTO link);
    ResponseLinkDTO searchLink (int idLink, String password);
    int metricsLink (int idLink);
    Boolean invalidateLink (int idLink);
}
