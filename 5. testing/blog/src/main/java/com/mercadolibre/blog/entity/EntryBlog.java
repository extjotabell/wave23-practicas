package com.mercadolibre.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryBlog {
    private Long id;
    private String title;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
}
