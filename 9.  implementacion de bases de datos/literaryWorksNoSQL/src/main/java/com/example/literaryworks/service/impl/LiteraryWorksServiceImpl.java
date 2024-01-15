package com.example.literaryworks.service.impl;

import com.example.literaryworks.exceptions.IdNoExistsException;
import com.example.literaryworks.model.dto.LiteraryWorksDTO;
import com.example.literaryworks.model.entity.LiteraryWorks;
import com.example.literaryworks.repository.ILiteraryWorksRepository;
import com.example.literaryworks.service.ILiteraryWorksService;
import com.example.literaryworks.utils.Mapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class LiteraryWorksServiceImpl implements ILiteraryWorksService {

    private final ILiteraryWorksRepository literaryWorksRepository;

    public LiteraryWorksServiceImpl(ILiteraryWorksRepository literaryWorksRepository) {
        this.literaryWorksRepository = literaryWorksRepository;
    }

    /*
     * Service to save one literary work
     */
    @Override
    public LiteraryWorksDTO saveLiteraryWork(LiteraryWorksDTO literaryWorksDTO) {
        LiteraryWorks literaryWorks = Mapper.mapToLiteraryWorks(literaryWorksDTO);
        literaryWorks = literaryWorksRepository.save(literaryWorks);
        return Mapper.mapToLiteraryWorksDTO(literaryWorks);
    }

    /**
     * Srvice to save a list of literary works
     */
    @Override
    public List<LiteraryWorksDTO> saveLiteraryWorks(List<LiteraryWorksDTO> literaryWorksDTOList) {
        Iterable<LiteraryWorks> literaryWorksIterable = Mapper.mapToLiteraryWorksIterable(literaryWorksDTOList);
        literaryWorksIterable = literaryWorksRepository.saveAll(literaryWorksIterable);
        return Mapper.mapToLiteraryWorksDTOList(literaryWorksIterable);
    }

    /**
     * Service to update one literary work
     */
    @Override
    public LiteraryWorksDTO updateLiteraryWork(LiteraryWorksDTO literaryWorksDTO) {
        if (!literaryWorksRepository.existsById(literaryWorksDTO.getId())) {
            throw new IdNoExistsException();
        }
        LiteraryWorks literaryWorks = Mapper.mapToLiteraryWorks(literaryWorksDTO);
        literaryWorks = literaryWorksRepository.save(literaryWorks);
        return Mapper.mapToLiteraryWorksDTO(literaryWorks);
    }

    /**
     * Get all literary works
     */
    @Override
    public List<LiteraryWorksDTO> getAllLiteraryWorks() {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository.findAll();
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     * Service to return all the literary works of an author given by the user.
     */
    @Override
    public List<LiteraryWorksDTO> findByAuthorLiteraryWorks(String authorLiteraryWorks) {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository.findByAuthorLiteraryWorks(authorLiteraryWorks);
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     * Service to return all the literary works that contain words given by the user in their titles.
     */
    @Override
    public List<LiteraryWorksDTO> findByNameLiteraryWorks(String nameLiteraryWorks) {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository.findByNameLiteraryWorks(nameLiteraryWorks);
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     * Service to return all the literary works with more pages than those indicated by the user.
     */
    @Override
    public List<LiteraryWorksDTO> findByQuantityPagesLiteraryWorksByRange(Integer quantityPagesLiteraryWorks) {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository.findByQuantityPagesLiteraryWorksByRange(quantityPagesLiteraryWorks);
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     * Service to return all the literary works that were published before a year given by the user
     */
    @Override
    public List<LiteraryWorksDTO> findByYearBeforeFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks) {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository
                                                        .findByYearBeforeFirstEditionLiteraryWorksByRange(yearFirstEditionLiteraryWorks);
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     * Service to return all the literary works that were published after a year given by the user
     */

    @Override
    public List<LiteraryWorksDTO> findByYearAfterFirstEditionLiteraryWorksByRange(Integer yearFirstEditionLiteraryWorks) {
        Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository
                                                        .findByYearAfterFirstEditionLiteraryWorksByRange(yearFirstEditionLiteraryWorks);
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }

    /**
     *   Service to return all the literary works of the same publisher.
     */
    @Override
    public List<LiteraryWorksDTO> findByEditorialLiteraryWorks(String editorialLiteraryWorks) {
         Iterable<LiteraryWorks> literaryWorksIterable = literaryWorksRepository.findByEditorialLiteraryWorks(editorialLiteraryWorks);
         return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }
}