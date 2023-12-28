package com.mercadolibre.blog.entity;

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
    private String date;

}
