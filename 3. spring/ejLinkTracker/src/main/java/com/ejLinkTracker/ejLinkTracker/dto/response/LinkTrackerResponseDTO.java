package com.ejLinkTracker.ejLinkTracker.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkTrackerResponseDTO {
    private String url;
    private String password;
    private int redirectCount;
}
