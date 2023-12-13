package com.ejercicio.blog.dto.request;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestBlogDto {
    private Integer id;
    private String titulo;
    private String autor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
