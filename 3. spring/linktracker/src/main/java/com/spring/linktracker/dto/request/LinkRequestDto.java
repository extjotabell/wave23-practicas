package com.spring.linktracker.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequestDto {
    private String url, password;
}
