package com.cifrado.Cesar;

import java.util.ArrayList;
import java.util.List;

public class ServicioCifrado {
    private static final List<Character> abc = List.of('a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','x', 'y', 'z');

    private static List<Integer> convertirClaveList(String clave) {
        List<Integer> claveArray = new ArrayList<Integer>();
        for (int i = 0; i < clave.length(); i++) {
            claveArray.add((int) clave.charAt(i) - (int) '0');
        }
        return claveArray;
    }

    private static StringBuilder cifradoCesar(String texto, List<Integer> claveArray) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            int k = claveArray.get(i % claveArray.size());
            // Al tratar con enteros positivos no existe ningún problema con usar "%" o "Math.floorMod"!
            int indice = (abc.lastIndexOf((texto.charAt(i))) + k) % abc.size();
            resultado.append(abc.get(indice));
        }
        return resultado;
    }

    private static StringBuilder descifradoCesar(String texto, List<Integer> claveArray) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            int k = claveArray.get(i % claveArray.size());
            // Notar que el operador % en Java retorna valores no deseados!
            int indice = Math.floorMod(abc.lastIndexOf((texto.charAt(i))) - k, abc.size());
            resultado.append(abc.get(indice));
        }
        return resultado;
    }

    public static String descifrar(String texto, String clave) {
        List<Integer> claveArray = convertirClaveList(clave);
        StringBuilder resultado = descifradoCesar(texto, claveArray);
        return resultado.toString();
    }

    public static String cifrar(String texto, String clave) {
        List<Integer> claveArray = convertirClaveList(clave);
        StringBuilder resultado = cifradoCesar(texto, claveArray);
        return resultado.toString();
    }

}
