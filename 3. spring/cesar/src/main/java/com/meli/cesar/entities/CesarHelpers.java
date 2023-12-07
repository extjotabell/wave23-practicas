package com.meli.cesar.entities;

public class CesarHelpers {
    public static final String[] ALPHABET = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I",
        "J","K", "L", "M", "N", "O", "P", "Q", "R",
        "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    public static final int ALPHABET_LENGTH = ALPHABET.length;

    public static String[] processText(String text) {
        text = text.toUpperCase();
        text = text.replaceAll("\\s", "");
        return text.split("");
    }
}
