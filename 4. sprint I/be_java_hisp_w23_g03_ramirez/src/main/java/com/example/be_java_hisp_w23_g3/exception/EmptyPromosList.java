package com.example.be_java_hisp_w23_g3.exception;

public class EmptyPromosList extends  RuntimeException{
    public EmptyPromosList(String message) {
        super(message);
    }
}
