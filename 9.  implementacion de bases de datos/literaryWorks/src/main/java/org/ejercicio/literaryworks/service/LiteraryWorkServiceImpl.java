package org.ejercicio.literaryworks.service;

import org.ejercicio.literaryworks.model.dto.LiteraryWorkDto;
import org.ejercicio.literaryworks.model.entity.LiteraryWork;
import org.ejercicio.literaryworks.repository.ILiteraryWorkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class LiteraryWorkServiceImpl implements ILiteraryWorkService {

    private final ILiteraryWorkRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();


    public LiteraryWorkServiceImpl(ILiteraryWorkRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LiteraryWorkDto> getAllLiteraryWork() {
        Iterable<LiteraryWork> literaryWorkIterable = repository.findAll();
        return getLiteraryWorkDtos(literaryWorkIterable);
    }

    private List<LiteraryWorkDto> getLiteraryWorkDtos(Iterable<LiteraryWork> literaryWorkIterable) {
        return getLiteraryWorkDtos(StreamSupport
                .stream(literaryWorkIterable.spliterator(), false));
    }

    @Override
    public LiteraryWorkDto saveLiteraryWork(LiteraryWorkDto literaryWorkDto) {
        LiteraryWork literaryWork = repository.save(modelMapper.map(literaryWorkDto, LiteraryWork.class));
        return modelMapper.map(literaryWork, LiteraryWorkDto.class);
    }

    @Override
    public void deleteLiteraryWork(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<LiteraryWorkDto> saveLiteraryWorks(List<LiteraryWorkDto> literaryWorkDtos) {
        List<LiteraryWork> literaryWorks = literaryWorkDtos
                .stream()
                .map(literaryWorkDto -> modelMapper.map(literaryWorkDto, LiteraryWork.class))
                .toList();

        Iterable<LiteraryWork> literaryWorkIterable = repository.saveAll(literaryWorks);

        return getLiteraryWorkDtos(literaryWorkIterable);
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByAuthor(String author) {
        List<LiteraryWork> literaryWorks = repository.findByAuthor(author);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }

    private List<LiteraryWorkDto> getLiteraryWorkDtos(Stream<LiteraryWork> literaryWorks) {
        return literaryWorks
                .map(literaryWork -> modelMapper.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByTitle(String title) {
        List<LiteraryWork> literaryWorks = repository.findByTitle(title);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByEditorial(String editorial) {
        List<LiteraryWork> literaryWorks = repository.findByEditorial(editorial);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByPages(Integer count) {
        List<LiteraryWork> literaryWorks = repository.findByPages(count);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByYearAfter(Integer year) {
        List<LiteraryWork> literaryWorks = repository.findByYearAfter(year);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }

    @Override
    public List<LiteraryWorkDto> getLiteraryWorksByYearBefore(Integer year) {
        List<LiteraryWork> literaryWorks = repository.findByYearBefore(year);
        return getLiteraryWorkDtos(literaryWorks
                .stream());
    }


}
