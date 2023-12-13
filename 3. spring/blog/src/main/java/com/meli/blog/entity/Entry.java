package com.meli.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Entry {

    private Integer id;
    private String title;
    private String author;
    private LocalDate date;

    public Entry(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = LocalDate.now();
    }
}
