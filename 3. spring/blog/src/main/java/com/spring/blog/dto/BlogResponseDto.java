package com.spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogResponseDto {
        private int id;
        private String title, autor;
        LocalDateTime fecha;
}
