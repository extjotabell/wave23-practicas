/*
* Un estudiante de programación intentó realizar declaraciones de variables con sus respectivos tipos en Java pero tuvo varias 
* dudas mientras lo hacía. A partir de esto, nos brindó su código y pidió la ayuda de un desarrollador experimentado que pueda 
* darle una mano. ¿Podrías verificar su código y realizar las correcciones necesarias?
*/
public class Main {
   String apellido = "Gomez";
   int edad = 35;
   boolean variable = false;
   double sueldo = 45857.90;
   String nombre = "Julián";
 
}

/*
 * Un programador comenzó con el planteo, pero neccesita un poco de ayuda para determinar las condiciones para cada uno de los 
 * casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?
 */
public class Main {

	String dni = "12345678"; // dni de ejemplo
	double sueldoBase = 21000; // monto de ejemplo
	double sueldoConAumento;

	public void calcularAumento() {

        // Tu codigo aqui
		if (sueldoBase <= 20000) {
			sueldoConAumento = sueldoBase + ((sueldoBase * 20) / 100);
		}
		else {
		  if (sueldoBase > 20000 && sueldoBase <= 45000){
				sueldoConAumento = sueldoBase + ((sueldoBase * 10)/100);
		  }
		  else if(sueldoBase > 45000){
				sueldoConAumento = sueldoBase + ((sueldoBase * 5)/100);
		  }else{
				sueldoConAumento = sueldoBase;
			}
		}

		System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
	}

    public static void main(String[] args) {
		new Main().calcularAumento();
	}

}

/*
 * Al momento de crear la clase Automovil se han cometido algunos errores en su diseño. ¿Puedes identificarlos y corregirlos 
 * siguiendo lo que has aprendido acerca de ellas?
 */
public class Automovil {
    String marca;
    String color;
    double kilometros;

    // Constructor por defecto
    public Automovil() {
    }

    // Constructor con parámetros
    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    // Método para mostrar la marca y el color
    public String mostrarMarcaYColor() {
        return "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
    }
}

/*
 * La operación realizada en el siguiente programa lanzará una excepción, necesitamos que realices el manejo correspondiente 
 * para lograr el siguiente comportamiento:
 * - Permitir la ejecución del código y capturar la excepción lanzada
 * - Imprimir por consola el mensaje de error de la misma al realizar la captura
 * - Imprimir por consola el texto de la variable mensajeFinal, de modo tal que se muestre siempre (es decir, se lance o no una excepción)
 */
import java.util.LinkedList;
import java.util.List;

public class Main {
    List<String> mensajeStrings = new LinkedList<>();
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";

    int[] numeros = new int[5];

    public void asignarValor() {
        //Código que arroja excepción, escribi tu codigo aqui
        try{
            numeros[5] = 10;
        }catch(IndexOutOfBoundsException e){
            imprimirMensaje(e.getMessage());
        }finally{
            imprimirMensaje(mensajeFinal);
        }
        
    }

    private void imprimirMensaje(String mensaje) {
        mensajeStrings.add(mensaje);
        System.out.println(mensaje);
    }
    
}

/*
 * Se plantea crear una clase con un método static llamado burbuja, q
 * ue recibe un arreglo de enteros primitivos int[] y devuelve el arreglo, 
 * ordenado de forma ascendente.
 */

public class Ejercicio1 {    

    public static int[] burbuja(int[] array) {     
        int n = array.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    swapped = true;
                }
            }
        } while (swapped);

        return array;
    }

}