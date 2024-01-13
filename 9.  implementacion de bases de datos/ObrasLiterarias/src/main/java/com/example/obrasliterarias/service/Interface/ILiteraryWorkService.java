package com.example.obrasliterarias.service.Interface;

import com.example.obrasliterarias.dto.LiteraryWorkDTO;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkDTO> findByAuthor(String author);
    List<LiteraryWorkDTO> findByTitle(String title);
    List<LiteraryWorkDTO> findByPageCountGreaterThan(String pageCount);
    List<LiteraryWorkDTO> findByFirstPublicationYearGreaterThan(String year);
    List<LiteraryWorkDTO> findByFirstPublicationYearLessThan(String year);
    List<LiteraryWorkDTO> findByPublisher(String publisher);
    void save(LiteraryWorkDTO literaryWorkDTO);
    List<LiteraryWorkDTO> findAll();
}
