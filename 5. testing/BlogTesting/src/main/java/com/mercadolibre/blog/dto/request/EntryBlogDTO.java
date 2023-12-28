package com.mercadolibre.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryBlogDTO {
    private Long id;
    private String title;
    private String name;
    private String date;

}
