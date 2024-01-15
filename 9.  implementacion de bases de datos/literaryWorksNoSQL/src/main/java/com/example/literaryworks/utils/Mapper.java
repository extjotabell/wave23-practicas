package com.example.literaryworks.utils;

import com.example.literaryworks.model.dto.LiteraryWorksDTO;
import com.example.literaryworks.model.entity.LiteraryWorks;

import java.util.List;
import java.util.stream.StreamSupport;

public class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static LiteraryWorksDTO mapToLiteraryWorksDTO(LiteraryWorks literaryWorks) {
        LiteraryWorksDTO literaryWorksDTO = new LiteraryWorksDTO();
        literaryWorksDTO.setId(literaryWorks.getId());
        literaryWorksDTO.setNameLiteraryWorks(literaryWorks.getNameLiteraryWorks());
        literaryWorksDTO.setAuthorLiteraryWorks(literaryWorks.getAuthorLiteraryWorks());
        literaryWorksDTO.setQuantityPagesLiteraryWorks(literaryWorks.getQuantityPagesLiteraryWorks());
        literaryWorksDTO.setEditorialLiteraryWorks(literaryWorks.getEditorialLiteraryWorks());
        literaryWorksDTO.setYearFirstEditionLiteraryWorks(literaryWorks.getYearFirstEditionLiteraryWorks());
        return literaryWorksDTO;
    }

    public static LiteraryWorks mapToLiteraryWorks(LiteraryWorksDTO literaryWorksDTO) {
        LiteraryWorks literaryWorks = new LiteraryWorks();
        literaryWorks.setId(literaryWorksDTO.getId());
        literaryWorks.setNameLiteraryWorks(literaryWorksDTO.getNameLiteraryWorks());
        literaryWorks.setAuthorLiteraryWorks(literaryWorksDTO.getAuthorLiteraryWorks());
        literaryWorks.setQuantityPagesLiteraryWorks(literaryWorksDTO.getQuantityPagesLiteraryWorks());
        literaryWorks.setEditorialLiteraryWorks(literaryWorksDTO.getEditorialLiteraryWorks());
        literaryWorks.setYearFirstEditionLiteraryWorks(literaryWorksDTO.getYearFirstEditionLiteraryWorks());
        return literaryWorks;
    }

    public static Iterable<LiteraryWorks> mapToLiteraryWorksIterable(List<LiteraryWorksDTO> literaryWorksDTOList) {
        return literaryWorksDTOList.stream().map(Mapper::mapToLiteraryWorks).toList();
    }

    public static List<LiteraryWorksDTO> mapToLiteraryWorksDTOList(Iterable<LiteraryWorks> literaryWorksIterable) {
        return StreamSupport.stream(literaryWorksIterable.spliterator(), false).map(Mapper::mapToLiteraryWorksDTO).toList();
    }
}
