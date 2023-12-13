package com.meli.linktracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLinkRequestDto {
    private String linkId;
    private String url;
    private String password;
    private long redirectCount;
    private boolean valid;
}