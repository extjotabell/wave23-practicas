package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.Request.URLDTO;
import com.linktracker.linktracker.dto.Response.LinkIDDTO;
import org.springframework.http.HttpHeaders;

public interface ILinkTrackerService {

    LinkIDDTO crearLink(URLDTO urldto);

    HttpHeaders crearRedireccion(Integer linkid);

    Integer retornarNumeroRedirecciones(Integer linkid);

    void invalidarLink(Integer linkid);
}
