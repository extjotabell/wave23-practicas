package com.spring.cifradoCesar.entities;

public class Cifrado {


    public static String codificar(String string, String clave) {
        int[] corrimientos = new int[clave.length()];
        for (int i = 0; i < corrimientos.length; i++) {
            corrimientos[i] = Integer.parseInt(clave.substring(i, i+1));
            System.out.println(corrimientos[i]);
        }
        String codificado = "";
        String strDecodificado = string.replaceAll("\\s","");
        for (int i = 0; i < strDecodificado.length(); i++) {
            char letra = strDecodificado.charAt(i);
            int letraAscii = (int) letra +corrimientos[i%corrimientos.length];
            if(letraAscii>90){
                letraAscii-=26;
            }
            codificado+=(char) letraAscii;
        }
        return codificado;
    }
}
