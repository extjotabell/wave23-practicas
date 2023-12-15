package com.example.ejercicio_link.service;

import com.example.ejercicio_link.dto.request.SaveLinkDto;
import com.example.ejercicio_link.dto.response.LinkDto;
import com.example.ejercicio_link.entity.Link;
import com.example.ejercicio_link.exception.NotValidException;
import com.example.ejercicio_link.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public LinkDto saveLink(SaveLinkDto linkDto) {
        Link link = objectMapper.convertValue(linkDto, Link.class);
        repository.saveLink(link);
        return objectMapper.convertValue(link, LinkDto.class);
    }

    @Override
    public String showLink(int id) {
        LinkDto linkDto = objectMapper.convertValue(repository.showLink(id), LinkDto.class);

        if(linkDto.getValid()){
            return linkDto.getUrl();
        } else throw new NotValidException("Link invalido");
    }

    @Override
    public LinkDto invalidLink(int id) {
        return objectMapper.convertValue(repository.invalidLink(id), LinkDto.class);
    }

}
