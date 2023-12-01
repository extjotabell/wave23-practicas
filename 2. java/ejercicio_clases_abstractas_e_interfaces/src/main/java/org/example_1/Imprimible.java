package org.example_1;

import java.util.List;

public interface Imprimible {
     String imprimiendo();

     static void imprimir(List<Imprimible> datos){
         for (Imprimible dato: datos
              ) {
             System.out.println("Imprimiendo "+ dato.imprimiendo());
         }
     }
}


