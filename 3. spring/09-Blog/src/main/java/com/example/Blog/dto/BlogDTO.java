package com.example.Blog.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDTO {
    private long id;
    private String title;
    private String author;
    private String date;
}
