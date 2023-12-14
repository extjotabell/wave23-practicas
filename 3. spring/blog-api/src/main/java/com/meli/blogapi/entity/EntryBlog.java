package com.meli.blogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntryBlog {
    private Long id;
    private String title;
    private String author;
    private Date publicationDate;
}
