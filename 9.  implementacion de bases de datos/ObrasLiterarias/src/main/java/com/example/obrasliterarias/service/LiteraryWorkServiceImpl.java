package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.LiteraryWorkDTO;
import com.example.obrasliterarias.entity.LiteraryWork;
import com.example.obrasliterarias.repository.ILiteraryWorkRepository;
import com.example.obrasliterarias.service.Interface.ILiteraryWorkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkServiceImpl implements ILiteraryWorkService {
    private ILiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkServiceImpl(ILiteraryWorkRepository literaryWorkRepository) {
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWorkDTO> findByAuthor(String author) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByAuthor(author);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByTitle(String title) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByTitle(title);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByPageCountGreaterThan(String pageCount) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByPageCountGreaterThan(pageCount);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByFirstPublicationYearGreaterThan(String year) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByFirstPublicationYearGreaterThan(year);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByFirstPublicationYearLessThan(String year) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByFirstPublicationYearLessThan(year);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findByPublisher(String publisher) {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findByPublisher(publisher);

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public void save(LiteraryWorkDTO literaryWorkDTO) {
        ObjectMapper mapper = new ObjectMapper();

        LiteraryWork literaryWork = mapper.convertValue(literaryWorkDTO, LiteraryWork.class);

        literaryWorkRepository.save(literaryWork);
    }

    @Override
    public List<LiteraryWorkDTO> findAll() {
        ObjectMapper mapper = new ObjectMapper();

        List<LiteraryWork> literaryWorks = literaryWorkRepository.findAll();

        return literaryWorks.stream()
                .map(literaryWork -> mapper.convertValue(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }
}
