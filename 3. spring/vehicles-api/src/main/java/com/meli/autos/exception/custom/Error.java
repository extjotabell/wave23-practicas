package com.meli.autos.exception.custom;

import lombok.Data;

@Data
public class Error {
    private final String message;
    private final String field;
}
