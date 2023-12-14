package com.spring.blog.mappers;

import com.spring.blog.dtos.BlogDto;
import com.spring.blog.model.EntradaBlog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BlogMapper {

    public static EntradaBlog mapBlogDtoToEntradaBlog(BlogDto blogDto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(blogDto.getFechaPublicacion(), formatter);
        return new EntradaBlog(blogDto.getId(), blogDto.getTitulo(), blogDto.getAutor(), date);
    }

    public static BlogDto mapEntradaBlogToBlogDto(EntradaBlog blog) {
        return new BlogDto(blog.getId(), blog.getTitulo(), blog.getAutor(), blog.getFechaPublicacion().toString());
    }
}
