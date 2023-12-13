package com.example.linktracker.service;

import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkMetricaDTO;
import com.example.linktracker.entity.Link;

public interface ILinkService {
    String redirectLinkById(Long id, String password);

    LinkIdDTO addLink(Link link);

    String deleteLink(Long idLink);

    LinkMetricaDTO getMetricaLink(Long id);
}
