package com.ejercicio.LinkTracker.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseLinkDTO {
    private int id;
    private String link;
    private Boolean active;
    private String password;
    private int statistic;
}
