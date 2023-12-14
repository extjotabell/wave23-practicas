package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.URL;

public interface ILinkTrackerRepository {

    Integer agregarURL(URL url);

    Boolean validarURL(Integer idlink);

    URL conseguirURL(Integer idlink);

    void incrementarContadorRedirecciones(Integer idlink);



}
