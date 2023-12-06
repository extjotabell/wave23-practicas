package com.meli.morsecode;

import com.meli.morsecode.service.MorseCodeService;

public class Main {
    public static void main(String[] args) {
        MorseCodeService mcs = new MorseCodeService();
        System.out.println(mcs.decode("-- . .-. -.-. .- -.. ---   .-.. .. -... .-. ."));
    }
}
