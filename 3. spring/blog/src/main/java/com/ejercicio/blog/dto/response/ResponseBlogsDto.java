package com.ejercicio.blog.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseBlogsDto {
    private List<ResponseBlogDto> blogs;
}
