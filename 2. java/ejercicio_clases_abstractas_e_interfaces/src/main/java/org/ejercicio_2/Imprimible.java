package org.ejercicio_2;

import java.util.List;

public interface Imprimible {

     //Es posible que esto es lo que requeria el ejercicio, pero para practicar un poco más sobre interfaces, decidí
     //hacerlo de esta manera junto con mi equipo
     //static void imprimible(Object imprimible) { System.out.println(imprimible.imprimir() i imprimible.ToString()); }
     String imprimir();
     static void imprimirDocumentos(List<Imprimible> documentos){
         for (Imprimible documento: documentos) {
             System.out.println(documento.imprimir());
         }
     }
}


