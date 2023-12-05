package com.meli.encrypted.service;

import com.meli.encrypted.exception.EncyptorException;

public class Main {
    public static void main(String[] args) throws EncyptorException {
        EncryptorService es = new EncryptorService();
        System.out.println(es.encryptKey("YO HE LOGRADO ENCENDER UNA CERILLA", new Integer[]{0, 1, 2}));
    }
}