package com.example.ejercicio_link.repository;

import com.example.ejercicio_link.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private int id = 0;

    HashMap<Integer, Link> data = new HashMap<>();

    @Override
    public void saveLink(Link link) {
        data.put(id,link);
        id = id +1;
    }

    @Override
    public Link showLink(int id) {
        data.get(id).setVisits(data.get(id).getVisits()+1);
        return data.get(id);
    }

    @Override
    public Link invalidLink(int id) {
        data.get(id).setValid(false);
        return data.get(id);
    }
}
