package com.spring.algoritmoCesar.service;

import java.util.Arrays;
import java.util.List;

public class CifrarCesarService {

    static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String fraseCifrada23(String frase) {

        StringBuilder res = new StringBuilder();
        List<String> listAbc = Arrays.stream(abc.split("")).toList();
        List<String> listFrase = Arrays.stream(frase.split("")).toList();

        listFrase = listFrase.stream()
                .filter(x -> !x.equals(" "))
                .map(String::toUpperCase)
                .toList();

        for (int i = 0; i < listFrase.size(); i++) {
            System.out.println("Cifrando letra: " + i);
            String letraFrase = listFrase.get(i);

            int indiceLetra = listAbc.indexOf(letraFrase);

            if (i % 2 == 0) {
                //se suma 2
                indiceLetra += 2;
            } else {
                //se suma 3
                indiceLetra += 3;
            }

            if (indiceLetra >= listAbc.size()) {
                indiceLetra -= listAbc.size();
            }

            res.append(listAbc.get(indiceLetra));
        }

        return res.toString();
    }

    public static String fraseCifrada012(String frase) {
        StringBuilder res = new StringBuilder();
        List<String> listAbc = Arrays.stream(abc.split("")).toList();
        List<String> listFrase = Arrays.stream(frase.split("")).toList();

        listFrase = listFrase.stream()
                .filter(x -> !x.equals(" "))
                .map(String::toUpperCase)
                .toList();

        for (int i = 0; i < listFrase.size(); i++) {
            System.out.println("Cifrando letra: " + i);
            String letraFrase = listFrase.get(i);

            int indiceLetra = listAbc.indexOf(letraFrase);

            if (i % 3 == 0) {
                //se suma 2
                indiceLetra += 0;
            } else if (i % 3 == 1) {
                //se suma 3
                indiceLetra += 1;
            } else {
                indiceLetra += 2;
            }

            if (indiceLetra >= listAbc.size()) {
                indiceLetra -= listAbc.size();
            }

            res.append(listAbc.get(indiceLetra));
        }

        return res.toString();
    }

    public static String fraseCifrada(String clave, String frase) {
        if (frase.trim().isEmpty() || frase.length() >= 10000) {
            return "la frase debe tener un largo entre 1 y 10,000";
        }
        StringBuilder res = new StringBuilder();
        List<String> listAbc = Arrays.stream(abc.split("")).toList();
        List<String> listFrase = Arrays.stream(frase.split("")).toList();

        listFrase = listFrase.stream()
                .filter(x -> !x.equals(" "))
                .map(String::toUpperCase)
                .toList();

        for (int i = 0; i < listFrase.size(); i++) {
            String letraFrase = listFrase.get(i);

            int indiceLetra = listAbc.indexOf(letraFrase);


            List<Integer> strClave = Arrays.stream(clave.split("")).map(Integer::parseInt).toList();
            indiceLetra += strClave.get(i % clave.length());

            if (indiceLetra >= listAbc.size()) {
                indiceLetra -= listAbc.size();
            }

            res.append(listAbc.get(indiceLetra));
        }

        return res.toString();
    }

    public static String fraseDescifrada(String frase, String clave){

        if (frase.trim().isEmpty() || frase.length() >= 10000) {
            return "la frase debe tener un largo entre 1 y 10,000";
        }
        StringBuilder res = new StringBuilder();
        List<String> listAbc = Arrays.stream(abc.split("")).toList();
        List<String> listFrase = Arrays.stream(frase.split("")).toList();

        listFrase = listFrase.stream()
                .filter(x -> !x.equals(" "))
                .map(String::toUpperCase)
                .toList();

        for (int i = 0; i < listFrase.size(); i++) {
            String letraFrase = listFrase.get(i);

            int indiceLetra = listAbc.indexOf(letraFrase);


            List<Integer> strClave = Arrays.stream(clave.split("")).map(Integer::parseInt).toList();
            indiceLetra -= strClave.get(i % clave.length());

            if (indiceLetra < 0) {
                indiceLetra += listAbc.size();
            }

            res.append(listAbc.get(indiceLetra));
        }

        return res.toString();
    }
}
