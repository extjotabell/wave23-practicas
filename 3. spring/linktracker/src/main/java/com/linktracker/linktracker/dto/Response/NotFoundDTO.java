package com.linktracker.linktracker.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotFoundDTO {
    private String mensaje;
    private Integer status;
}
