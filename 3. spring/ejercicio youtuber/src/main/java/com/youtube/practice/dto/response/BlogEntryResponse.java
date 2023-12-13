package com.youtube.practice.dto.response;

public class BlogEntryResponse {
    private String message;

    public BlogEntryResponse() {
    }

    public BlogEntryResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
