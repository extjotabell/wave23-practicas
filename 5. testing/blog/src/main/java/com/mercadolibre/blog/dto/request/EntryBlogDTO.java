package com.mercadolibre.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

}
