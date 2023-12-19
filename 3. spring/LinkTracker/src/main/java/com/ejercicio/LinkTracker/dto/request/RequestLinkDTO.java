package com.ejercicio.LinkTracker.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class RequestLinkDTO {
    private String link;
    private Boolean active;
    private String password;
}
