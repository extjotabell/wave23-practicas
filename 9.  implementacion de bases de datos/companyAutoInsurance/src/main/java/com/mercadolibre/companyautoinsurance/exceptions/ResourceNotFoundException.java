package com.mercadolibre.companyautoinsurance.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Vehicle not found.";
    public ResourceNotFoundException() {
        super(MESSAGE);
    }
}
