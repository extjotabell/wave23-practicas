package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.URL;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepositoryImp implements ILinkTrackerRepository {

    private List<URL> urls = new ArrayList<>();
    @Override
    public Integer agregarURL(URL url) {
        url.setId(urls.size() + 1);
        url.setValido(true);
        url.setNumeroRedirecciones(0);
        urls.add(url);
        return url.getId();
    }

    @Override
    public Boolean validarURL(Integer idlink) {
        return urls.stream().anyMatch(u -> u.getId().equals(idlink) && u.getValido());
    }

    @Override
    public URL conseguirURL(Integer idlink) {
        return urls.stream().filter(u -> u.getId().equals(idlink)).findFirst().get();
    }

    @Override
    public void incrementarContadorRedirecciones(Integer idlink) {
        URL url = conseguirURL(idlink);
        url.setNumeroRedirecciones(url.getNumeroRedirecciones() + 1);
    }


}
