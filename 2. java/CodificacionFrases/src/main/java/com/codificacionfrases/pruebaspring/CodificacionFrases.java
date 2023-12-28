package com.codificacionfrases.pruebaspring;

import java.lang.reflect.Array;
import java.util.*;

public class CodificacionFrases {

    private String abecedario = "ABCDEFGHIJKLMNOPQRSTUVXYZ";

    public String codificarMensaje(int clave, String mensaje){
        String[] abecedarioArray = abecedario.split("");

        List<String> listaLetras = new ArrayList<>(Arrays.asList(abecedarioArray));

        listaLetras.stream().map(letra -> letra.equals());



        return "";
    }



}
