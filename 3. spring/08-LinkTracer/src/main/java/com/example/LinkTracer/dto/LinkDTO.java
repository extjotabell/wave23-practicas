package com.example.LinkTracer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String originalURL;
    private String password;
    private int redirectCount;
    private boolean valid;
}
