package com.ejercicio.blog.dto.response;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResponseBlogDto {
    private Integer id;
    private String titulo;
    private String autor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPublicacion;
}
