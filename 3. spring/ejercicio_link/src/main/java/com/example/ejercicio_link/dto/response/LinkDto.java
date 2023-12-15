package com.example.ejercicio_link.dto.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class LinkDto {
    private String url;
    private Boolean valid;
    private String password;
    private int visits;
}
