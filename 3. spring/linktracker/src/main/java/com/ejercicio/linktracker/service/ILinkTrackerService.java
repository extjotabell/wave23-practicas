package com.ejercicio.linktracker.service;

import com.ejercicio.linktracker.dto.request.RequestLinkDto;
import com.ejercicio.linktracker.dto.response.ResponseCreatedLinkDto;

import com.ejercicio.linktracker.dto.response.ResponseInvalidateLinkDto;
import com.ejercicio.linktracker.dto.response.ResponseRedirectNumberDto;
import org.springframework.http.HttpHeaders;

public interface ILinkTrackerService {
    ResponseCreatedLinkDto createLink(RequestLinkDto urlDto);

    HttpHeaders redirect (Integer linkid);

    ResponseRedirectNumberDto returnRedirecNumber (Integer linkid);

    ResponseInvalidateLinkDto invalidateLink (Integer linkid);
}
