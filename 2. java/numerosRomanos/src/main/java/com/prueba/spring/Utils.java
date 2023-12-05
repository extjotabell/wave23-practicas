package com.prueba.spring;

public class Utils {

    public static String numeroRomano(int numero){
        int cantM = numero/1000;
        numero-= 1000*cantM;
        int cantD = numero/500;
        numero-=500*cantD;
        int cantC = numero/100;
        numero-=100*cantC;
        int cantL = numero/50;
        numero-=50*cantL;
        int cantXXX=numero/30;
        numero-=cantXXX*30;
        int cantXX=numero/20;
        numero-=cantXX*20;
        int cantXIII = numero/13;
        numero-=13*cantXIII;
        int cantX = numero/10;
        numero-=10*cantX;
        int cantVII = numero/7;
        numero-=7*cantVII;
        int cantV = numero/5;
        numero-=5*cantV;
        int cantIV = numero/4;
        numero-=4*cantIV;
        int cantIII = numero/3;
        numero-=3*cantIII;
        int cantII = numero/2;
        numero-=2*cantII;
        return "M".repeat(cantM) +  "D".repeat(cantD) +"C".repeat(cantC) +
                "L".repeat(cantL) +"XXX".repeat(cantXXX) + "XX".repeat(cantXX) + "XIII".repeat(cantXIII) +"X".repeat(cantX)+
                "VII".repeat(cantVII) +  "V".repeat(cantV) +"IV".repeat(cantIV)+
                "III".repeat(cantIII) +  "II".repeat(cantII) +"I".repeat(numero);
    }

    public static String numeroRomano1(int numero){
        String romano = "";
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < numbersToCompare.length; i++) {
            int repeticiones = numero/numbersToCompare[i];
            numero-=repeticiones*numbersToCompare[i];
            romano+=romanNumbers[i].repeat(repeticiones);
        }
        return romano;
    }
}
