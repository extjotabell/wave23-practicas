package com.ejercicio.blog.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseErrorDto {
    private String message;
    private int status;
}
