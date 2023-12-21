package com.meli.obtenerdiploma.model;

import lombok.*;
import org.jboss.logging.Messages;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDto {
    private String explanation;
    private List<String> message;
}
