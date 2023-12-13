package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.entity.EntradaBlog;
import com.example.youtuber.exception.BlogAlreadyExistException;
import com.example.youtuber.exception.BlogDoesNotExistException;
import com.example.youtuber.repository.IYoutuberRepository;
import com.example.youtuber.repository.YoutuberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoutuberService implements IYoutuberService {

    private final IYoutuberRepository youtuberRepository;

    public YoutuberService(YoutuberRepository youtuberRepository) {
        this.youtuberRepository = youtuberRepository;
    }

    @Override
    public void create(EntradaBlogDTO entradaBlogDTO) {
        if (youtuberRepository.get(entradaBlogDTO.getId()).isPresent())
            throw new BlogAlreadyExistException();
        youtuberRepository.create(new EntradaBlog(entradaBlogDTO.getId(),
                entradaBlogDTO.getTitulo(), entradaBlogDTO.getAutor(), entradaBlogDTO.getFecha()));
    }

    @Override
    public EntradaBlogDTO get(int id) {
        return youtuberRepository.get(id).map(EntradaBlogDTO::new).orElseThrow(BlogDoesNotExistException::new);
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        return youtuberRepository.getAll().stream().map(EntradaBlogDTO::new).toList();
    }


}
