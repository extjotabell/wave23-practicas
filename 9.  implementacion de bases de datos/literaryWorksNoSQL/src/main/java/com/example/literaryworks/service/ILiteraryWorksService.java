package com.example.literaryworks.service;

import com.example.literaryworks.model.dto.LiteraryWorksDTO;

import java.util.List;

public interface ILiteraryWorksService {

    LiteraryWorksDTO saveLiteraryWork(LiteraryWorksDTO literaryWorksDTO);
    List<LiteraryWorksDTO> saveLiteraryWorks(List<LiteraryWorksDTO> literaryWorksDTOList);
    LiteraryWorksDTO updateLiteraryWork(LiteraryWorksDTO literaryWorksDTO);
    List<LiteraryWorksDTO> getAllLiteraryWorks();
    List<LiteraryWorksDTO> findByAuthorLiteraryWorks(String authorLiteraryWorks);
    List<LiteraryWorksDTO> findByNameLiteraryWorks(String nameLiteraryWorks);
    List<LiteraryWorksDTO> findByQuantityPagesLiteraryWorksByRange(Integer quantityPagesLiteraryWorks);
    List<LiteraryWorksDTO> findByYearBeforeFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks);
    List<LiteraryWorksDTO> findByYearAfterFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks);
    List<LiteraryWorksDTO> findByEditorialLiteraryWorks(String editorialLiteraryWorks);
}