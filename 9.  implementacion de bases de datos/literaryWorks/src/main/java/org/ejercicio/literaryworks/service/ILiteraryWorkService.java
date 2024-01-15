package org.ejercicio.literaryworks.service;

import org.ejercicio.literaryworks.model.dto.LiteraryWorkDto;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkDto> getAllLiteraryWork();

    LiteraryWorkDto saveLiteraryWork(LiteraryWorkDto literaryWorkDto);

    void deleteLiteraryWork(String id);

    List<LiteraryWorkDto> saveLiteraryWorks(List<LiteraryWorkDto> literaryWorkDtos);

    List<LiteraryWorkDto> getLiteraryWorksByAuthor(String author);

    List<LiteraryWorkDto> getLiteraryWorksByTitle(String title);

    List<LiteraryWorkDto> getLiteraryWorksByPages(Integer count);

    List<LiteraryWorkDto> getLiteraryWorksByYearAfter(Integer year);

    List<LiteraryWorkDto> getLiteraryWorksByYearBefore(Integer year);

    List<LiteraryWorkDto> getLiteraryWorksByEditorial(String editorial);
}
