package com.meli.encrypted.model;

public class Request {
    private String sentence;
    private Integer [] movements;

    public Request(String sentence){
        this.sentence = sentence;
    }
    public Request(String sentence, Integer[] movements) {
        this.sentence = sentence;
        this.movements = movements;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Integer[] getMovements() {
        return movements;
    }

    public void setMovements(Integer[] movements) {
        this.movements = movements;
    }
}
