package com.linktracker.linktracker.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class URLDTO {
    private String url;
    private String password;
}
