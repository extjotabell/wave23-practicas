package com.ejercicioBlog.ejercicioBlog.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private int status;
}
