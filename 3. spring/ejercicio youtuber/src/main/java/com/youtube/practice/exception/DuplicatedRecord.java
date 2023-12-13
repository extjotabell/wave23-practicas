package com.youtube.practice.exception;

public class DuplicatedRecord extends RuntimeException {
    public DuplicatedRecord() {
    }

    public DuplicatedRecord(String message) {
        super(message);
    }
}
