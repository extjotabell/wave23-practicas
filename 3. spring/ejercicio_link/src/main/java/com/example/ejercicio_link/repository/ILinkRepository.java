package com.example.ejercicio_link.repository;

import com.example.ejercicio_link.entity.Link;

public interface ILinkRepository {
    void saveLink(Link link);

    Link showLink(int id);

    Link invalidLink(int id);
}
