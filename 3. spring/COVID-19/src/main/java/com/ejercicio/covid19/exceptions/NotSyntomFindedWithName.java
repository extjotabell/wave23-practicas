package com.ejercicio.covid19.exceptions;

public class NotSyntomFindedWithName extends Exception {
    public NotSyntomFindedWithName() {
        super("Ups! El síntoma no se encuentra.");
    }
}
