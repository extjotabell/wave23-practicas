package com.example.be_java_hisp_w23_g3.dto.response;

public class ExceptionResponseDTO {
    private String message;

    public ExceptionResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


