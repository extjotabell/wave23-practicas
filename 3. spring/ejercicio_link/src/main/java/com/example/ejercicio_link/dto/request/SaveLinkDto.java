package com.example.ejercicio_link.dto.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SaveLinkDto {
    private String url;
    private String password;
}
