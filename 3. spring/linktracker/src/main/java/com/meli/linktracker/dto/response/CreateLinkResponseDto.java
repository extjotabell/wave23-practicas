package com.meli.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLinkResponseDto {
    private String linkId;
    private String url;
    private String password;
    private long redirectCount;
    private boolean valid;
}
