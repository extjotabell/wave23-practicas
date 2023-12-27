package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class InputBlogDto {
    private int idBlog;
    private String titleBlog;
    private String authorBlog;
    private LocalDate postDateBlog;
}

