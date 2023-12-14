package com.meli.blogapi.dto.request;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntryBlogDTO {
        private Long id;
        private String title;
        private String author;
        private String publicationDate;
    }

