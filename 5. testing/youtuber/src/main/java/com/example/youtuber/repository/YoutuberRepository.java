package com.example.youtuber.repository;

import com.example.youtuber.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class YoutuberRepository implements IYoutuberRepository {

    private final Map<Integer, EntradaBlog> entradasBlog;

    public YoutuberRepository() {
        this.entradasBlog = new HashMap<>();
    }

    @Override
    public void create(EntradaBlog entradaBlog) {
        entradasBlog.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public Optional<EntradaBlog> get(int id) {
        return Optional.ofNullable(entradasBlog.get(id));
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradasBlog.values().stream().toList();
    }
}
