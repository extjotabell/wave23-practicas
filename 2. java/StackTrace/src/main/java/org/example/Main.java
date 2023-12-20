package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       try{
           FileInputStream fileInputStream = new FileInputStream("prueba.txt");
       }catch (FileNotFoundException exception){
           exception.printStackTrace();
       }
    }
}