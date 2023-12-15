package com.example.ejercicio_link.service;

import com.example.ejercicio_link.dto.request.SaveLinkDto;
import com.example.ejercicio_link.dto.response.LinkDto;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {
    LinkDto saveLink(SaveLinkDto linkDto);
    String showLink(int id);

    LinkDto invalidLink(int id);
}
