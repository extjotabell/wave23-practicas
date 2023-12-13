package com.mercadolibre.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) class representing a blog entry.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryBlogDTO {
    private Long id;
    private String title;
    private String name;
    private String date;

}
