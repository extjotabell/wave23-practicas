package com.ejercicio.linktracker.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestLinkDto {
    private String url;
    private String password;
}
