# wave23-practicas 🚀
by Digital House 💗

way to work 🎯

Repositorio de practicas de Bootcamp DH Java Wave 23

## Directrices de creación de ramas

Al momento de crear las ramas convenimos una directriz de "Naming" para las mismas:

* El nombre debe ser en lowercase (minuscula).
* Debe contener unicamente el nombre y apellido del bootcamper.
* Si tienen muchos nombres y apellidos, usar su primer nombre y su primer apellido.
* Usar snake_case.

Ejemplo:

```
 git branch [apellido]_[nombre]
```

## Flujo de trabajo


Cada desarrolador cuenta con un branch con la estructura ya creada a su nombre para trabajar en las prácticas y desafíos.

1. Clonar el repositorio (branch y estructura)
     
   `git clone https://github.com/extjotabell/wave21-practicas.git`
   
2. Entrar a la carpeta del proyecto clonado y crear el branch con su apellido y nombre

   `git branch [apellido]_[nombre]`
   o
   `git checkout -b [apellido]_[nombre]`
   
3. Subir la rama que crearon
   
   `git push -u origin [apellido]_[nombre]`

4. Luego trabajar con el flujo habitual 

   `git add .`
   
   `git commit -m "mensaje de commit"`
   
   `git push`

-----------

## Estructura de carpetas en proyectos

![](https://res.cloudinary.com/dgt2h7onu/image/upload/v1684190033/folder_structure_ibfbv5.png)

# COSAS A RECORDAR EN JAVA

## Tipos de Datos en Java

### Short
Es un tipo de dato en Java utilizado para números de corto alcance.

### String
Aunque no es un tipo de dato primitivo en Java, String es una clase utilizada para representar cadenas de texto.

### Void
Es un tipo de dato primitivo "nulo" utilizado para funciones que no retornan un valor.

## Operaciones de Lectura y Escritura

### Lectura
```java
System.out.println("Palabra que queremos imprimir");
```
SE PUEDE USAR UN SHORTCOUT en IntelliJ que se escribe soup

### Escritura:
```java
Scanner teclado = new Scanner(System.in); // Declaramos Scanner para poder leer del teclado.

int num = teclado.nextInt();
String nombre = teclado.next();
double promedio = teclado.nextDouble();
```
- NOTA: Dependiendo el tipo de variable se usan diferentes funciones next(); Con el Scanner.
- OJO INVESTIGAR EL TIPO DE DATO VAR
- Cuando Nosotros inicializamos una variable siempre tienen por defecto un valor asigando, en caso
de numericos es:

- 0
- 0.0
- 0.000
- En el caso de Caracteres es el Caracter vacio.
- En el caso de los objetos el valor por defecto es NULL.

### Comandos
PSVM ----> Te crea el public Static Void Main:
- 
#0# SWITCH ANTIGUO VS SWITCH NUEVO

### Switch Antiguo
```java
switch (result){
	case 1: mensaje = "Aprobado";
	break;
	case 2: mensaje = "Reprobado";
	break;
	default: mensaje = "No lo se";
	break;
}
```
### Switch Nuevo
```java
switch (result){
case 1 -> {
Funcion a ejecutar; // Ya no es necesario el break en este caso.
}
}
```
# Revision del JDK
Para revisar el JDK, debemos verificar el archivo 'pom.xml' en la etiqueta properties.

# Arrays en Java

### Declaracion e Inicializacion
```java
int numeros[] = new int[6]; // Inicializamos y definimos su tamaño
numeros[0] = 10;
```
### Recorrer Arrays unidimensionales (Forma normal)
```java
for (int = 0; i <numeros.length; i++){
    System.out.println("Estoy en el indice: " + i);
    System.out.println("Tengo Guardado un:  "  + numeros [i]);

} 
```
### Recorrer Arrays unidimensionales (Forma For-each ) (investigar)


# Matrices
Es una combinacion de 2 dimensiones entre filas y columnas.

### Se declara de la siguiente manera:
```java
int matriz[][] = new int[3][3]; // declaro e inicializo una matriz de 3 filas y tres columnas.

```
### Carga (Manual)
```java
    numeros[0][0] = 52;
    numeros[0][1] = 133;
```

### Forma acotada:
```java
    int [][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
```

### Recorrer una matriz:
```java
for(i=0; i<=2; i++){
    for(j=0; j<=10; j++){
        System.out.println("Fila:" + i + "Columnas:" + j);
        System.out.println("Tengo guardado un" + i matriz[i][j]);
    }
}
```
### Error de desbordamiento:
Los errores de desbordamiento se producen cuando intentamos hacer referencia a una posicion en el array (vector o matriz) que no existe o que esta fuera de los limites del tamaño que declaramos.

# Collections
Las collecions son unn tipo de estructura dinamica que permite
el almacenamiento de un conjunto de objetos o elementos
-Extienden de la clase collection y permiten implementar metodos comunes como:
    -Añadir
    -Eliminar
    -Obtener el tamaño de la collection
    -Etc.
### Set o Conjuntos:
Un conjunto es una coleccion de elementos con la unica restriccion de que no permite elementos repetidos dentro.
Los elementos deben tener implementado equals y hashCod

## List:
Esta extiende de igual forma de la clase collection pero a diferencia de "set" esta
si permite elementos duplicados.
Nos permite agrupar una coleccion de elementos en forma de lista es decir, uno destras de otro.

-ArrayList
-LinkedList
-Stack

### Declaracion:

```java
import java.util.ArrayList;

List<String> listPersonas = new ArrayList<String>();

//Actualmente ya no es necesario pasar el tipo de dato en la instanciacion es decir podemos poner:
List<String> listPersonas = new ArrayList<>();

```
### Carga
```java
listPersonas.add("Cristiano Ronaldo");
listPersonas.add("Lionel Messi");
```
### Recorrido:
```java
//forma 1
for(String person : listaPersonas){
    System.out.println("Hola soy: " + person);
}

//forma 2
for(int i = 0; i < listaPersonas.size(); i++){
    System.out.println("Hola soy: " + listaPersonas.get(i));
}
```

## LinkedList (Listas enlazadas)
Las listas enlazadas se caracterrizan por ser estructuras dinamicas que tienen punteros que permiten enlazar "doblemente"
cada uno de sus elementos.
- Permiten dupplicados
- Permiten poder instertar, eliminar elementos, tanto al principio como al final de la colection.
- Puede ser tratada no solo como una lista sino tambien como una pila o una cola.

### Declaracion:

```java
import java.util.LinkedList;

List<String> listaPersonas = new LinkedList<String>();
```

### Carga
```java
listaPersonas.add("Cristiano Ronaldo");

// Agregar al principio:
listaPersonas.add(0, "Cristiano Ronaldo");
```

### Recorrido:
```java
for(String persona : listaPersonas){
    System.out.println("Hola soy: " + persona);
        }
```

## Maps o Diccionarios:
Esta no extiende de la clase collection, lo que hace es asociar relaciones clave-valor, es el equivalente
a lo que llamamos diccionarios en Python.
- Las claves no pueden ser duplicadas 
- Cada una de las claves solo pueden tener asociado un valor como maximo.
- Dicha key nos permitira posteriormente recuperar, modificar o eliminar el elemento.

### Declaracion:

```java
import java.util.HashMap;

Map<Integer, String> mapa = new HashMap<>();
```
### Carga y eliminacion:
```java
mapa.put(1,"Uno");
mapa.put(2,"Dos");
mapa.put(3,"Tres");
mapa.put(4,"Cuatro");

String valor = mapa.get(2); //Traemos el valor asociado a la key 2
System.out.println(valor); // Monstramos por pantalla el valor asociado a la key
mapa.remove(2); //Eliminamos el elemento con la key 2

```
### Recorrer un Map:

```java
import java.util.Map;
for(Map.Entry<Integer, String> entrada : mapa.entrySet()){ // EntriSet nos da una forma de poder alvergar el par key-value. No recorremos el HashMap sino un EntrySet.
    Integer clave = entrada.getKey();
    String valor = entrada.getValue();
    System.out.println("La clave es: " + clave + "El valor es: " + valor);
        }
```
# Programacion Orientada a Objetos (POO):
La programación orientada a objetos es un paradigma de programación en donde todo se resume a que cualquier 
objeto de la vida real puede ser representado de manera lógica. 

A partir de esto, surgen dos conceptos muy importantes: 
El de Objetos y el de Clases e Instancias.

## Objetos 
Es algo que se define apartir de sus responsabilidades y atributos y van a depénder del contexto 
en el cual se este trabajando.

## Clases e Instancias:
Clase es un modelado de un objeto, la abstraccion del concepto que representa dicho objeto, es un molde o "idea"

Instancia y objeto son sinonimos, es decir es hacer uso de la clase para poder crear objetos.

## Constructores
Es un metodo que se define en una clase, el cual funciona para crear una instancia de una clase, es decir
crear un objeto.

## Definicion de una clase:
```java
public class NombreClase{
    //Declaracion variables de instancia
    tipoDato variable1;
    tipoDato variable2;
    
    //Declaracion de Metodos.
}
```
### Creacion de un Objeto:
```java
Libro libro = new Libro(); //Iniciamos definiendo el tipo de dato, luego indicamos el nombre de la variable y por ultimo invocamos al metodo constructor.

```

## Metodos:
Es un conjunto de Instruccions definidas dentro de una clase que realizan una tarea determinada.
Se identifican por tener parentesis despues de su nombre. Un metodo tendra:
- Un modificador de Acceso
- Un tipo de retorno
- El nombre (debe ser descriptivo)
- Puede o no tener parametros.
### Definicion de un Metodo:
```java
public int sumarNumero(int numero1, int numero2){
    //Cuerpo del metodo
    return numero1 + numero2;
}
```
### Metodo Main
- La palabra public indica que puede ser accesido desde cualquier parte del programa
- La palabra reservada static indica que no tiene que crearse un objeto de esta clase para ser llamada
- Void indica que este metodo no retorna ningun valor.
- El nombre de metodo debe ser main.
- Debe aceptar un array de String. El nombre de los parametros o argumerntos del metodo ouede ser cualquier identificardo valido.
```java
public class Main{
    public static void main(String[] args){
        System.out.println("Hola mundo");
    }
} 
```

### Metodos de Instancia VS Metodos de Clase:
Los metodos de Instancia pueden ser accedidos mediante una instancia u objeto de una clase:
```java
public class Libro{
    private String nombreLibro;
    private String autor;
    
    public String mostrarNombreConAutor(){
        System.out.println(nombreLibro + " " + autor);
    }
    
    public String mostrarNombreSinAutor(){
        System.out.println(nombreLibro);
    }
}
```
```java
//Sintaxis de llamada:
//instancia.metodo(parametros);
Libro libro = new Libro();
libro.mostrarNombreConAutor();
libro.mostrarNombreSinAutor();
```
### Metodos de Clase:
Son aquellos que pueden ser llamados sin existir una instancia de la clase, por ejemplo la 
clase java-lang.Math

## Constructores:
Es un tipo especial de metodo que nos sirve oara crear un objeto, es decir instanciar una clase.

- El nombre del metodo constructor debe coincidir con el nombre de la clase
- No tiene tipo de retorno
- La existencia de parametros es opcional
- Puede existir mas de uno, aunque solo se ejecutara uno al momento de crearse la clase.

```java
//Constructor sin parametros:
public Libro(){
    
}

// Constructor con parametros:
public Libro(String nombre, String autor){
    this.nombre = nombre;
    this.autor = autor;
}
```
### Sobre Carga de un constructor
Puede existir mas de un metodo constructor teniendo el mismo nombre de la clase.
pero variando en el numero de parametros que contenga.

### Relaciones entre Clases

Nos indican como se comunican las clases entre si, existen varios tipos:

- Asociacion: Es unilateral es decir en un solo sentido la clase A conoce a la B pero la B no conoce a la A(Tiene-conoce)
- Agregacion: Cuando una clase contiene totalmente a la otra.
- Composicion: Cuando una clase esta compuesta de otro, Un cuerpo esta compuesto de Organos. Una de las clases no tiene sentido por su cuenta
- y depende si o si de la otra.

##Excepciones y Clases Utilitarias

# Excepciones
Un programa puede fallar por muchas raones algunos pueden ser causados por errores en el codigo, otros estan
completamente fuera de nuestro control. Las Excepciones son eventos que alteran el flujo del programa

## Tipos de Exepciones

### Excepciones Chequeadas (Checked)
Son aquellas que deribasn de la clase exception. Deben ser declaradas o manejadas, es decir
requieren realizar un bloque try.catch. 
Entre las clases mas comunes encontramos:
-  FileNotFoundException -> Lanzada programaticamente cuando el codigo trata de referencias a un archivo inexistente.
- IOException -> Lanzada cuando hay un problema leyendo o escribiendo un archivo.
### EJEMPLO:
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;

try {
    FileInputStream fileInputStream = new FileInputStream("prueba.txt");
    } catch(FileNotFoundException exception){
        System.out.println("El archivo indicado no existe");
    }
```

### Excepciones no chequeadas (Unchecked)
Derivan de la clase RuntimeException, no deben ser manejadas o declaradas, es decir no requieren 
el uso obligatorio del bloque try/catch. Las mas comunes son:

- ArrayIndexOutOfBoundsException -> Lanzada por la JVM cuando se utiliza un indice no permitido al acceder a un array.
- IllegalArgumentException -> Lanzada por el programados para indicar que se ha pasado un argumento inapropiado o no permitido a un metodo.
- NullPointerException -> Lanzado por el programador para indcar que se ha pasado un argumento inapropiado o no permitido a un metodo.
- NullPointerException -> Lanzado por la JVM cuando la referencia a un objeto es nula al momento de requerir el objeto.

### EJEMPLO:
```java
int valor = 0;
double resultado = 10 / valor;
```

# Errores

Los errores derivan de la clase Error, son conocidos por ser lanzados por la JVM, y no pueden ser resueltos o solucionados,
por lo que el programa normalmente se detiene. Indican problemas graves en nuestra aplicacion, suelen ser poco comunes,
pero podrias llegar a ver alguno de los siguientes.

- ExceptionInInitializerError -> Lanzado por la JVM cuando un inicializador estatico lanza una excepcion y el mismo no se maneja.
- StackOverflowError -> Lanzado por la JVM cuando un metodo se llama a si mismo demasiadas verces. (Recursividad inficnita)
- NoClassDefFoundError -> Lanzada por la JVM cuando una clase utiliza el codigo esta disponible en tiempo de compilacion pero no en tiempo de ejecucion.


## Jerarquia De Excepciones

En java, todas las excepciones estan representadas por clases. Las clases de exception derivan de una clase llamda
Throwable.

## Stack Tracer (OJO Aprender esto)

La pila de llamadas, es una lista de llamadas a metodos que se han realizado en la aplicacion cuando una excepcion fue lanzada.
Se muestra desde el metodo mas reciente donde se genero la excepcion. Este orden nos permite identificar la causa principal del
fallo de manersa quwe es mas facil, ya que es mas probable que encontremos la misma en los emtodos mas recientes ejecutados.

### Ejemplo:

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;

try{
FileInputStream fileInputStream = new FileInputStream("Prieba.txt");
}catch(FileNotFoundException exception){
    exception.printStackTrace();
        }
```

# Manejo de Excepciones

Java nos permite hacer un control de excepciones para que nuestro programa continue su ejecucion aunque se produzca
una excepcion. Para ello contamos con la estructura try-catch-finally.

### Try
Este bloque significa qintentar, todo el codigo dentro de esta sentencia sera el codigo sobre el que se intentara
capturar una excepcion en caso de que ocurra.

### Catch
Aqui definimos el conjunto de instrucciones necesarias o de tratamiento del problema capturado que ha sido
lanzado en el bloque try.

### Finally
En este bloque podremos definir un conjunto de instrucciones necesarias que se ejecutaran tanto si se produce la excepcion como si no. por lo
tanto se ejecutara siempre.

## Sintaxis de la estructura try - catch - finally
```java
try{
    //Codigo protegido
        } catch(TipoExcepcion identificador){
        // Manejo de la excepcion
        } finally {
            //Bloque finally.
        }
```
# Nota:

- El codigo ene l bloque try corre normalmente, si cualquiera de sus lineas lanza una excepcion, el bloque try se detiene y comienza la ejecucion del bloque catch
- Si ninguna de sus sentencias en el bloque try lanzan una excepcion que pueda ser atrabapa, la clausula catch no se ejecuta.
- Hay dos caminos si se lanza una excepcion finally se ejecuta despues del catch, caso contrario se ejecuta despues del try.
- Se puede usar el metodo .getMessage(); en un objeto exception para obtener mayor informacion. Ejempo:
```java
exception.getMessage();
```

# Throw

La palabra reservada Throw nos permite lanzar una excepcion, debe estar seguida del operador new y del tipo de excepcion que 
queremos lanzar. La ejecucion se detiene inmediatamente despues de la sentencia throw, por lo que no se ejecutara
ninguna de las sentencias siguientes.
#### NOTA: Lo usamos cuando queremos que se muestre si o si una excepcion.
#### Ejemplo:
Cuando nosotros consultamos un usuario que no existe en una base de datos se nos regresa un nulo o vacio.
En este caso nosotros deberiamos lanzar una exepcion mas descriptiva de lo que ha pasado.

# Clases Utilitarias

Las clases Utilitarias son clases que definen un conjunto de metodos que realizan funciones que tienen que ver entre si,
normalmente muy utilizadas. la mayoria de estas clases definen metodos estaticos. por ejemplo la clase java.lang.Math
```java
double coseno = Math.cos(30);
double tangente = Math.tan(15);
double potencia = Math.pow(2,5);
long redondeo = Math.round(20.5);
```
Otro ejemplo de las clases utilitarias puede ser la clase LocalDateTime para el manejo de fechas y tiempo, la cual fue introducida apartir de
Java 8 para solucionar problemas de las antes usadas clases Date y Time.

```java
// Haciendo Uso de los metodos:

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

LocalDateTime ldt1 = LocalDateTime.now();

LocalDateTime ldt2 = LocalDateTime.of(2021, Month.APRIL,20,8,20,15,11);

LocalDateTime ldt3 = LocalDateTime.parse("2021-08-03T10:15:30");
```

# Herencia
Se refiere a un objeto que comparte el mismo concepto pero que se compone de diferentes atributos, haciendo una analogia en a¿la vida real
se parte de una clase padre que contiene metodos y atributos que se pueden hertedar a una clase hija para que conserve esas mismas caracteristicas
y ademas se puedan sumar mas.
- Java soporta herencia simple es decir, que una clase puede heredar solamente de una clase padre de manera directa.
- Puedes heredar de una clase tantas veces como quieras, esto eprmitira a sus hijos tener acceso a losmmiembros de la clase padre.
- Java no soporta hertencia multiple sin embrago, puede lograrse algo similar a este tipo de herencia.
# Polimorfismo
Es uno de los pilares de la programacion orientada a objetos, refiere a la propiedad de un objeto de tomar diferentes formas.

#### Ejemplo: Si tuvieramos una clase animal y de ella deriban varios animales.
```java
public void hacerSonido(){
    System.out.println("Miau");
}
public void hacerSonido(){
    System.out.println("Guau");
}
public void hacerSonido(){
    System.out.println("Meeeeee");
}
```
# Encapsulamiento
El encapsulamiento consiste en controlar el acceso a los datos que conforman un objeto o instancias de una clase, es decir,
debemos indicar que metodos y atributos son publicos para que puedan ser accedidos por otras entidades e incluso ser modificados
En terminos de una clase Java significa configurar la clase para que solamente los emtodos de esa clase con sus
variables puedan referir a las variables de la instancia.

En temrminos genrales se busca proteger los datos contra el acceso y la modificacion imprevista o no controlada.

## Setters y getters

- Getter: Es un metodo que, al ser llamado, retorna un valor de una variable.
- Setter: Es un metodo que, al ser llamado define o configura el valor dfe una variable.

#### NOTA: 
Las variables de una instancia usualmente se definen como private, mientras que los metodos setter y gettes son
publicos dando la posibilidad a otras clases de interactuar con la clase en cuedstion sin exponer sus metodos y
atributos publicamente.

## Packages o Paquetes en Java
Un paquete es un grupo de clases similares, interfaces y sub-paquetes. Pueden ser categorizados como: 
- Paquetes incorporados (Built-in-package)
- Paquetes definidos por el usuario (User-defined package)

Exisaten varios paquetes incorporados como java. lang, awt, javax etc.

Esto se utiliza para categorizar las clases y las interfaces para que puedan ser facilmente mantenidas
- Proveen proteccion al acceso
- Evitan problemas con la colision de  nombres.
## Modificadores de Acceso:

- public: Puede ser llamado o accedido desde cualquier clase.
- private: Puede ser llamado solamente dentro de la misma clase.
- protected: Puede ser llamado desde clases e el mismo package o subclase.
- default (package private): Puede ser llamado solamente desde clases en el mismo paquete. No existe una palabra reservada para el acceso por defecto. simplemente debes omitir el modificart de acceso.

## Clase Object

Toda clase en Java deriva (directa o indirectamente) de la clase Object. es decir, todas las clases heredan de Object.

- boolean equals(Object object) : Este metodo indica si otro objeto es igual al actual
- String toString : Este metodo retorna una representacion del objeto.

### Heredar de una clase en java
Podemos heredar de una clasde agregando el nombre de la clase padre y usando la palabra reservada extends

```java
public class Mamifero extends Animal{
    // Metodos y variables definidas aqui.
}
```

### Ventajas de la herencia:

- Favorece la reutilizacion de codigo. Las subclases utilixan el codigo de las superclases
- Faclita el mantenimiento de las aplicaciones. podemos cambiar las clases que usamos facilmente
- Facilita la extension de las aplicaicones. podemos crear nuevas clases apartir de otras existentes.

### Sobreescritura (Overriding):

Es la forma por la cual una clase que hereda de otra puede re-definir los metodos de la clase padre,
permitiendo crear nuevos metodos que tengan el mismo nombre de su superclase pero aplicando comportamientos diferentes.
Podemos identificas un metodo sobreescrito ya que tiene la anotacion @Override, no es obligatoria en todos
los casos pero si es recomendable usarla.
Las condiciones para poder sobreescribnir un metodo son:

- La firma del mismo debe ser IGUAL al metodo original de la clase padre (Mismo nombre, tipo y cantidad de argumentos como parametros.)
- El tipo de retorno debe ser el mismo
- No debe tener un nivel de acceso mas restrictivo que el original.
- No deben ser metodos static ni final.

# Nota:

Para cuando hacemos uso de un metodo de una clase previamente heredada hacemos uso de la palabra reservada:
#### super.(nombre_atributo) ---> Esto es en lugar del this.especia = especie en el constructor
Lo mismo sucede cuando sobreescribimos un metodo o lo llamamos:
#### super.nombreMetodo();

# Clases Wrapper

- Son clases envoltorio, que representan a un dato primitivo en forma de Objeto
- Anidan un valor primitivo para darle funcionalidad
- Proveen metodos de conversion a tipos compatibles
- metodos de validacion
- Equivalen a un tipo de referencia o clase
- Cada primitivo posee su clase equivalente 

### Referencia
- byte -> Byte
- short -> Short
- int -> Integer
- char -> Character
- boolean -> Boolean

### Ejemplo 

```java
int valorPrimitivo1 = 123;
Integer valor1 = Integer.valueOf(valorPrimitivo1);
Integer valor2 = 123;
Integer valor3 = Integer.valueOf(123);
```

### Algunos Metodos Clase Integer:
- Integer.parseInt(String s) -> Convierte a un int
- Integer.valueOf(String s) -> Convierte en un Integer
- Integer.toString(int i) -> Convierte a una cadena un entero.
- Integer.compareTo(Integer value) -> devuelve un int
- Integer.equal(Integer value) -> Devuelve un boleano

# Generics 
- Ademas del polimorfismo, una caracteristica que permite a la plataforma java tratar homogeneamoente objetos de los que
habitualmente no se conoce su tipo concreto, son los tipos genericos.
- En su escencia, el termino genericos significa tipos parametrizados. Son importantes porque permiten crear clases, interfaces y metodos en los que el tipo de datos sobre los que operan se especifica como parametro.
- Al definir una clase generica, o bien una interfaz, en realidad estamos definiendo un meta-tipo/pseudotipo, una especie de plantilla a partir de la cual se crearan posteriormente clases/interfaces que actuaran como tipos concretos
### Ejemplo:

```java
import java.util.Comparator;

public class ComparaEnteros implements Comparator<Integer> {
    public int compare(int a, int b) {
        return a - b;
    }

    public class ComparaCadenas implements Comparator<string>{
        public int compare(String s1, String s2){
            return s1.compareTo(s2);
        }
    }
}
```
### Java Generics Ejemplo
```java
// Se le indica que la clase contendra genericos <T>
public class MyGenerics <T>{
    // Puede contener atributos genericos:
    private T genericsfield;
    private Integer field;
    //El constructor puede contener el generico:
    public MyGenerics(T genericsfield, Integer field){
        this.genericsfield = genericsfield;
        this.field = field;
    }
    // Los metodos pueden devolver genericos:
    public T getGenericsfield(){
        return genericsfield;
    }
    // Los metodos pueden recibir genericos
    public void setGenericsField(T genericsfield){
        this.genericsfield = genericsfield:
    }
}
```

## Clases Lambda y Streams

Otro aspecto importante cuando se trabja con Java es la utilizacion de otros conceptos como Lamda y Streams.

### Programacion Funcional
- Es un paradigma de programacion, se utilizan "funciones puras", que producen siempre el mismo resulotado para los mismos argumentos de entrada y no tienen efectos secundarios en el estado del rpgrama
- En java, las funciones puras se implementan utilizando expresiones lambda y el tipo de interfaz funcional correspondiente.
- Un concepto importante de la programacion funcional es la inmutabilidad de los datos, que se refiere a que una vez que se crea el objeto, no se puede modirficar su estado.

### ¿Por que es tan importante?

La programacion funcional de Java puede mejorar la calidad, reducir la cantidad de errores y hacer que el codigo sea mas facil de mantener y escalar.
En java, la programaicon funcional se ha convertidfo en una tecnica popular para desarrollar aplicaiones robustas y escalables.

Al utilizar tecnicas de programacion funcional, los desarrolladores pueden escribir codigo mas legible y que sea mas facil de comprender y reutilizar.

Un programador Java que sabe prgramacion funcional se diferencia por centrarse en la creacion y manipulacion de funciones, en lugar de fijarse 
principalmente en la manipulacion de objetos y el estado mutable.

## ¿Que es una exprecion lambda?
- Una expresion lambda en Java es una forma de crear una funciona anonima y pasarla como argumento a otro metodo o funcion.
- Se integra desde ea JDK 1.8, para incorporar la programacion funcional. Basicamente implementan metodos sin necesidad de una clase
- Una expresion lambda puede recibir varios parametros, pero no retorna solo uno.
- Un ejemplo de su sintaxis es:
```java
(parametro) -> {Cuerpo de la funcion}
```
Donde el parametro es el parametro de entrada de la fucnio y el cuerpo es el codigo que se ejecutara cuando se invoque
la misma. el parametro puede ser un valor, un objeto o una lista de valores separados por comas.
- Un ejemplo de expresion lambda es:
```java
(x) -> {x * 2}
```
Esta expresion lambda toma un numero entero x como entrada y devuelve x * 2 como resultado.
- Existen otras formas tambien de aplicar la sintaxis, como ser por ejemplo: c
- Su uso mayormente es para imc¿plementar metodos de interfaces funcionales, entendiendo una interfaz funcional como
- aquella que solo posee un metodo abstracto. @FunctionalInterface.

### Tipos de extpreisones lambda:
```java
p -> {System.out.println(p)} // Aceptan un parametro pero no devuelven ninguno.
(p,q) -> {System.out.println(p+q)} // Aceptan dos parametros pero no devuelven ninguno
() -> 10 // No poseen paraametros y devuelven un resultado.
p -> p+10 // Aceptan un parametro y devuelven un resultado.
```

### Referencias a metodos
- Es una praxctica que consiste en emplear un metodo como una expresion lambda
- En java, se puede hacer una referencia a un metodos estatico, un metodo de instancia o un constructor utilizando el operador ::
Ejemplo:
```java
ReferenciaArgumento :: Nombre del Metodo
var -> System.out.println(var) eqivale a System.out::println
var -> Math.sqrt(var) eqivale a Math::sqrt
```

## API Stream
La API Stream en java es una caracteristica introducida en Java 8 que permite procesar colecciones de datps de forma mas facil
y eficiente utilizando programacion funcional.

Un Stream es una secuencia de elementos que puede ser procesada en paralelo o en serie.

Con la API Stream, se pueden realizar operaciones como filtrar, mapear, ordenar y reducir elementos de una coleccion de datos
de forma eficiente y concisa

- Permite crear flujos de datos continuos para procesar con operadores.
- Hacer uso de expresiones lambda para reducir las tareas de transformacion.
- Algunos operadores para transformar o componer son el filter, map flatmap, sorted, foreach, reduce.
- Son inmutables 
- Pueden crearse desde colecciones: Set, List o Map.
### Fuente de datos:
```java
List<String> listaDatos = Arrays.asList("dato1", "dato2", "dato3");
Stream<String> stream = listaDatos.stream();

```
### Operaciones Intermedias

Las operaciones intermedias se realizan en el Stream y devuelven un nuevo Stream. Estas operaciones son transformaciones o filtraciones que se aplican a los elementos del Stream original. Algunas operaciones intermedias comunes son:

- filter: Filtra elementos según un predicado.
- map: Transforma cada elemento aplicando una función.
- flatMap: Transforma y aplana elementos en un solo Stream.
- sorted: Ordena los elementos del Stream.
- Ejemplo:

```java
Stream<String> resultado = stream.filter(s -> s.startsWith("dato")).map(String::toUpperCase).sorted();
```

### Operaciones Terminales:
Las operaciones terminales producen un resultado o un efecto secundario, y consumen el Stream. Algunas operaciones terminales comunes son:

- forEach: Ejecuta una acción para cada elemento del Stream.
- reduce: Combina los elementos del Stream en un solo resultado.
Ejemplo:

```java
resultado.forEach(System.out::println);

String concatenacion = listaDatos.stream().reduce("", (a, b) -> a + b);

```

## Ejemplo de implementacion:
Sin stream:
```java
import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        // Crear una lista de nombres
        List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Ana");

        // Utilizar un bucle for each para recorrer la lista e imprimir cada nombre
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
    }
}

```
Con stream:
```java
import java.util.Arrays;
import java.util.List;

public class StreamForEachExample {
    public static void main(String[] args) {
        // Crear una lista de nombres
        List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Ana");

        // Crear un Stream a partir de la lista de nombres
        nombres.stream()
                // Utilizar forEach para imprimir cada nombre
                .forEach(nombre -> System.out.println("Nombre: " + nombre));
    }
}

```
Mas ejemplos con Operacion intermedia .map y .filter

```java
import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        // Crear una lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Ejemplo 1: Filtrar números pares y multiplicar por 2
        numeros.stream()
                .filter(n -> n % 2 == 0)   // Filtrar números pares
                .map(n -> n * 2)           // Multiplicar por 2
                .forEach(System.out::println);  // Imprimir resultado

        // Ejemplo 2: Convertir cadenas a mayúsculas y filtrar por longitud
        List<String> nombres = Arrays.asList("Juan", "María", "Carlos", "Ana");
        nombres.stream()
                .map(String::toUpperCase)   // Convertir a mayúsculas
                .filter(nombre -> nombre.length() > 4)  // Filtrar por longitud mayor a 4
                .forEach(System.out::println);  // Imprimir resultado
    }
}

```
# Clases Abstractas e Interfaces

Una clase Abstracta es muy similar a una clase comun, posee metodos, atributos y un constructor.
Pero tiene almenos un metodo abstracto. un metodo abstracto es un metodo vacio, cuya utilidad es definir que puede hacer esa clase, pero
no el como.

- Una clase se convierte en abstracta si posee almenos un metodo abstracto.
- Puede ser heredada, y las clases hijas deben implementar los metodos abstarctos
- Si bien poseen constructor, las clases abstractas no se pueden instanciar.
- su contructor esta pensado para que sea heredado por sus clases hijas.
- Sirven para agrupar el comportamiento similiar de otras clases
- Sirven como "Plantilla" para otras clases que tengan atributos o metodos comunes.
```java
// Clase abstracta Figure
abstract class Figure {

    // Método abstracto para calcular el área
    public abstract double calculateArea();

    // Método abstracto para calcular el perímetro
    public abstract double calculatePerimeter();

    // Método abstracto para mostrar información sobre la figura
    public abstract void displayInfo();
}

// Clase concreta que extiende Figure (por ejemplo, un círculo)
class Circle extends Figure {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementación del método abstracto para calcular el área de un círculo
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementación del método abstracto para calcular el perímetro de un círculo
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    // Implementación del método abstracto para mostrar información sobre el círculo
    @Override
    public void displayInfo() {
        System.out.println("Círculo con radio: " + radius);
    }
}

// Clase de prueba
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Circle
        Circle circle = new Circle(5.0);

        // Llamar a métodos de la clase Circle
        circle.displayInfo();
        System.out.println("Área: " + circle.calculateArea());
        System.out.println("Perímetro: " + circle.calculatePerimeter());
    }
}

```
### Interfaz 

Se pude definir como una interfaz como una agrupacion de metodos abstractos y atributos constantes (o inexistentes)
que especifica una serie de metodos, dejando que el comportamiento sea definido por las clases hijas que implementen a la interfaz.

- Solo pueden extender/implementar otras interfaces
- Permiten implementacion multiples, es decir, una clase puede implementar varias interfaces al mismo tiempo.
- Al igual que las clases abstractas, NO PUEDEN SER INSTANCIADAS
- Solo pueden tener metodos publicos (no pueden ser ni private ni protected) 
- Solo puede tener atributos constantes (es decir, definidos como static y final)
Ejemplo:

```java
// Interfaz Figure
interface Figure {
    double calculateArea();
    double calculatePerimeter();
    void displayInfo();
}

// Clase abstracta que implementa la interfaz Figure
abstract class AbstractFigure implements Figure {
    // Puedes proporcionar implementaciones comunes aquí
    @Override
    public void displayInfo() {
        System.out.println("Información genérica de la figura.");
    }
}

// Clase concreta Circle que extiende AbstractFigure
class Circle extends AbstractFigure {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementación del método para calcular el área de un círculo
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementación del método para calcular el perímetro de un círculo
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    // Sobrescribe el método displayInfo para proporcionar información específica del círculo
    @Override
    public void displayInfo() {
        System.out.println("Círculo con radio: " + radius);
    }
}

// Clase de prueba
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Circle
        Circle circle = new Circle(5.0);

        // Llamar a métodos de la clase Circle
        circle.displayInfo();
        System.out.println("Área: " + circle.calculateArea());
        System.out.println("Perímetro: " + circle.calculatePerimeter());
    }
}

```

Puede definir el metodo default Ejemplo:
```java
// Interfaz Figure con un método default
interface Figure {
double calculateArea();
double calculatePerimeter();
void displayInfo();

    // Método default para proporcionar información predeterminada
    default void displayDefaultInfo() {
        System.out.println("Información predeterminada de la figura.");
    }
}

// Clase concreta Circle que implementa la interfaz Figure
class Circle implements Figure {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementación del método para calcular el área de un círculo
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementación del método para calcular el perímetro de un círculo
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    // Sobrescribe el método displayInfo para proporcionar información específica del círculo
    @Override
    public void displayInfo() {
        System.out.println("Círculo con radio: " + radius);
    }
}

// Clase de prueba
public class Main {
public static void main(String[] args) {
// Crear una instancia de Circle
Circle circle = new Circle(5.0);

        // Llamar a métodos de la interfaz Figure
        circle.displayInfo();
        System.out
```

Interfaz Generica
```java
// Interfaz genérica SimpleList
interface SimpleList<T> {
    void addItem(T item);
    void displayItems();
}

// Implementación de SimpleList para una lista de String
class StringList implements SimpleList<String> {
    private java.util.List<String> items = new java.util.ArrayList<>();

    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public void displayItems() {
        System.out.println("Elementos de la lista de cadenas:");
        for (String item : items) {
            System.out.println(item);
        }
    }
}

// Implementación de SimpleList para una lista de Integer
class IntegerList implements SimpleList<Integer> {
    private java.util.List<Integer> items = new java.util.ArrayList<>();

    @Override
    public void addItem(Integer item) {
        items.add(item);
    }

    @Override
    public void displayItems() {
        System.out.println("Elementos de la lista de enteros:");
        for (Integer item : items) {
            System.out.println(item);
        }
    }
}

// Clase de prueba
public class Main {
    public static void main(String[] args) {
        // Uso de la interfaz SimpleList con StringList
        SimpleList<String> stringList = new StringList();
        stringList.addItem("Hola");
        stringList.addItem("Mundo");
        stringList.displayItems();

        // Uso de la interfaz SimpleList con IntegerList
        SimpleList<Integer> integerList = new IntegerList();
        integerList.addItem(42);
        integerList.addItem(7);
        integerList.displayItems();
    }
}

```

# ¿Cuando Usamos una clase Abstarcta?

Cuando no tiene sentido en si instanciar esa clase sino que tiene sentido instanciar solo clases hijas.

## NOTA: Para nombre de interfaces es recomendable agregar la terminacion -able -IDibujable, -IColoreable, -IManejable etc, ADEMAS de agregar la letra I
Despues cuando creamos una oimplementacion de la interfaz, debemos agregar al nombre, la palabra Impl por ejemplo CuadradoImpl implements IDibujable
Es como una regla universal de interfaces e Implementaciones de las mismas.

# Spring Boot

## Arquitectura cliente-servidor

Es un modelo de diseño de software en el que las tareas se reparten entre los provedores de recursos o servicio, llamados
servidores, y los demandantes llamados clientes.

- Los clientes realizan peticiones a los servidores (request)
- Los servidores le brindan una respuesta respecto a lo que el cliente solicita(response)

El cliente puede ser representado por una computadora local de uso comun, que intenta acceder a un servicio
via internet o de red interna. Los clientes mas conocidos son chrome, mozilla, Opera y Safari.

El servidor al igual que el cliente tambien es una computadora, pero con la diferencia de que tiene una gran 
capacidad de procesamiento como almacenamiento o manejo de aplicaciones en simultaneo que le permite atender la
cantidad de solicitudes que recibe de los clientes.

### Ventajas y Desventajas
#### Ventajas
- Facilita la integracion entre sistemas diferentes y comparte informacion
- Facil Mantenimiento: Al estar las funciones y responsabilidades de forma distribuida entre varios servicios o partes independientes, es posible reemplazar, reparar, actualizar, o incluso trasladar un servidor, mientras que sus clientes no se veran afectador.
- Escalabilidad: Se puede aumentar la cantidad de clientes o servidores por separado sin que esto afecte a los ya existentes. Cualquier elemento puede ser aumentado en cualquier momento, o se pueden añadir nuevos nodos a la red.
- El hecho de que permita utilizar protocolos como HTTP y/o HTTPS, asegura de alguna manera la implementacion de seguridad en el intercambio de datos exsisteince entre clientes y servidores.
#### Desventajas

- Cuello de botella: La congestion del trafico ha sido siempre un problema en el paradigma cliente-servidor. Cuando una gran cantidad de clientes envian peticiones simultaneas al mismo servidor, puede ser que cause muchos problemas para este si el servidor no posee la capacidad suficiente para servirlos.
- Si un servidor esta caido y no tiene otro respaldo, las peticiones de los clientes no pueden ser satisfechas.
- El cliente no dispone de los recursos que puedan existir en el servidor. Para poder utilizar los recursos del servidor debe enviar una request.
- Los clientes no pueden compartir informacion entre si de forma directa. Siempre el servidor es el intermediario para todas las comunicaciones.


### Protocolo HTTP

HTTP significa Hypertext Transfer Protocol y es un protocolo que tiene como finalidad la comunicacion entre el cliente
y el servidor.

Es un rptocolo orientado a transacciones, donde el cliente realiza una peticion enviando un mensaje o request con cierto formato
al servidor y este, posteriormente, le envia un mensaje de respuesta (response).

Cabe resaltar que es un protocolo sin estado, es decir que no guarda informaicon sobre conexiones anteriores.

### ¿Como se refleja en una aplicacion?

Generalmente el backend se ve reflejado como el servidorm mientras que el forntend como el cliente.

### Request y Reposnes ¿Cuales son sus formatos?

Cada uno de los mensajes existentes entre el cliente y el servidor tiene una estructura con la cual son enviados mediante la red existente.

## Request
- METHOD: Se indica que metodo se esta utilizando para enviar el mensaje. Existen diferentes metodos, algunos de los mas conocidos son: GET, POST, PUT, PATCH, DELETE.
- URL: Direccion a donde se esta enviando la peticion.
- HEADER(cabecera): Atributos generales o esenciales que se incluyen (por ejemplo Auth).
- Body: Cuerpo del mensaje utilizado en las peticiones para poder transmitir datos.

## Response

### STATUS
Es un codigo que representa que sicede con una peticion. Existen diferentes "Status Code"
- 1xx: Respuestas informativas, indica que la peticion ha sido recibida y se esta procesando
- 2xx: Respuestas correctas, indica qie la peticion ha sido procesada correctaente.
- 3xx: Respuestas de redireccion.
- 4xx: Errores causados por el cliente. (Ejemplo: Not Found)
- 5xx: Errores causados por el servidor. (Ejemplo 500 Internal Server Error.)
-------
- Header(cabecera): Atributos generales o esenciales que se incluyen (por ejemplo: Auth).
- Body: Respuesta del Mensaje.

# Frameworks VS Librerias

## Libreria / biblioteca

Las librerias son un conjunto de funcionalidades, que resuelven necesidades especificas de un determinado proyecto, que pueden
ser epaquetadas para poder reutilizarlas a futuro para determinadas situaciones.

Generalmente las librerias son fragmentos de codigo que nos permiten resolver problemas en concreto, por ejemplo,
manejo de fechas, para ciertos componentes de una interfaz grafica, para conexiones con bases de datos, entre otros.

Existen librerias externas y librerias caseras. las externas son proporcionadas generalmente por empresas
o progrmadores experto, mientras que las caseras pueden ser desrrolladas por el mismo programador de un proyecto para
reutilizar varias veces.

## ¿Que es un framework?

Un framework es un conjunto de archivos y pautas que definen la estructura y metodologia sobre como hacer el
desarrollo de un proyecto de software. Se podria decir que es una guia de esquema que nos ayuda a programar de 
forma mas sencilla y rapida.

Los frameworks, a diferencia de las librerias, son entornos completos de trabajo, por lo cual en muchos casos incluyen 
o utilizan no una sino un conjunto de librerias o dependencias. en la mayoria de los casos, los frameworks
se centran en un o¡solo lenguaje de programacion.

# MAVEN

Maven es una herramienta de software para la gestion y construccion de proyectos en Java que se caracteriza por tener un modelo
de configuracion de construccion muy simple, basado en el formato xml.

Maven utiliza Proyect Object Model (POM) para describir el proyecto de software a construir, sus depedencias de otros modulos, componentes
externos y el orden de construccion de los elementos. viene con objetivos predefinidos para realizar ciertas tareas claramente definidas,
como la compilacion del codigo y su empaquetado.

Maven nos permite instalar librerias dentro de nuestor proyecto de una forma mas facil y escalable. Varios IDES estan integtrados con IntelliJ IDEA para hace ruso
de complementos o librerias.

Cuando trabajamos con frameworks que utilizan dependencias o librerias necesitamos de un gestor que nos provea y ayude a encontrar
estas de forma mas rapida eficiente y compatible con nuestro proyecto, para eso nos ayuda MAVEN.

## Spring Platform

- Es un conjunto de proyectos open source desarrollados en ajva con el objetivio de agilizar el desarrollo de aplicaciones.
- Cuenta con gran variedad de herramientas, que nos facilitan el trabajo desde el acceso a datos, infraestructura, creacion de aplicaciones web, microservicios etc.

## Spring Framework
- Es un famewqork para el desarrollo de aplicaciones y contenedor de inversion de control, de codigo abierto para la plataforma JAVA.

- Spring framework puede ser usado en cualquier aplicacion desarrollada en java, sin embargo en los ultimos tiempos se lo utiliza primordialmente para la construccion de aplicaciones web sobre la plataforma Java EE.

## Core Spring:
![](https://www.google.com/search?sca_esv=600400644&rlz=1C5GCEA_enMX1084MX1084&q=core+spring&tbm=isch&source=lnms&sa=X&ved=2ahUKEwinnLXA1fGDAxVXMEQIHVL6BM4Q0pQJegQIERAB&biw=1440&bih=730&dpr=2#imgrc=eORgfcc93YsDLM)

## ¿Que es Spring Boot?

- Es una extension de Spring Framework que permite la creacion facil y rapida de aplicaciones web listas para produccion con el concepto Jurt run
- Requiere una minima configuracion y se complementa con muchos proyectos de Spring Platform y librerias de terceros.

### ¿Como crear un proyecto en Spring Boot Initializr?

- Spring initializr es una pequeña utilidad Web que permite crear un esqueleto de un proyecto Spring Boot con las opciones que queramos configurar.
- Permite elegir el proveedor de dependencias(Maven, Gradle, etc), el lenguaje a utilizar (Java, kotlin, etc), el tipo de mepaquetado (Jar, war), las dependencias / librerias que necesitamos, entre otras configuraciones.
- Se puede utilizar desde su web oficial, o descargando un complemento para IntelliJ idea o el IDE que estemos utilizando.

## Estructura del proyecto 
Se crean los siguientes archivos y direcitorios. Entres los mas importantes se encuentran.
- pom.xml
- application.properties o su equivalente application.yml
- carpeta target (luego de buildear el proyecto)
- profile (definir entorno de trabajo)

### Application.java
- Spring boot viene con un servidor embebido que nos permite ejecutar una applicacion directamente desde el archivo main que contiene la anotacon @SpringBootApplication, desde cualquier IDE.

## Creacion de Proyecto SpringBoot con Initializr.

- Buscamos en el navegador el siguiente link: https://start.spring.io/
- Elegimos Maven Project
- Lenguaje Java
- 2.5.2 La version mas estable actualmente en Spring Boot
- Datos del proyecto
- Package name es la combinacion del grupo y artefacto que elegimos.
- Le ponemos un nombre al proyecto y artefacto.
- Descripcion del Proyecto
- Packaging : Jar o War
- Elegimos la verison de Java: 11
- Añadimos las dependencias que requitamos por ejemplo:
  - Spring Boot DevTools
  - Spring Web ---> todo lo que necesitmaos para la web
  - Lombok ---> Libreria de notaciones de java para mejorar codigo

- Damos click en generate y nos genera un zip descargable, lo descomprimimios y abrimos en nuestro IDE y listo, ya esta.
## API's

Application Programming Interfaces, es decir don intermedarias que nos permiten la interconexion e intercambio de informacion entre diferentes sistemas. Ahora bien, otra pregunta que puede surgir es como crear una
, como usarla, en que me facilita como desarrollador.

Existen Apis Publicas, privadas y semi publicas
Un endpoint  hace referencia al punto de conexion donde se apunta para obtenr rla informacion de un servidor.

## SSL (Secure Socker Layer) 
Se utiliza para encriptar la informacion.

## Spring Boot (Configuraciones y prmieros pasos)

### Patron MVC

El Modelo-Vista-Controlador es un patron de aqrquitectura de software que separa la logica de negocio, de la logica de la vista en una aplicacion.

- Modelo: Se encarga de los datos, generalmente consultando alguna fuente de datos.
- Controlador: Se encarga de contorlar; recibe las ordenes del usuario, solicita los datos al modelo y  se los comunica a la vista.
- Vista: Es las representacoin visual de los datos.

### ¿Como se aplica el MVC en una app web?

- Modelo: Esta conformado por el conjunto de clases que utilicemos para realizar el correspondiente modelado(Tanto logica de negocios como de base de datos, etc) de nuestra aplicaicon.
- Vista: Esta representada por el Frontend, donde podemos tener un archivo HTML o un JSP (Java Server Pages) que sirve de interfaz grafica al usuario para obtener sus solicitudes.
- El controlador: Es el punto de union entre el modelo y la vista y como su nombre indica, se encarga de controlar la vista que tiene que mostrar, los datos que se incluiran en esta y de recopilar los datos enviados desde la vista para actuar en consecuencia(guardarlos, hacer una consulta, etc).
- Para crear un controlador con Spring Boot simplemente tenemos que añadir la anotacion @RestController a la clase de Java que determinamos para esto.


## API (Application Programming Interface)
### ¿Que es una API REST?
- Una API es un conjunto de funciones y procedimientos (metodos) que se usa para diseñar e integrar el software de diferentes aplicaciones.
- REST (Representational State Tranfer) es un tipo de servicio que no posee estado, Es cualquier interfaz (interconexion) entre sistemas que use HTTP como protocolo para obtener datos o generar operaciones sobre los mismos en formatos ocmo XML y JSON.

### ¿Que nos permite hacer una API?

- Una API nos permite interconectar sistemas sin importar el lenguaje en el que esten desarrollados.
- Una API permite ofrecer un determinado servicio / Aplicacion para que pueda ser consumido por diversos clientes al mismo tiempo.
- Una de las principales funciones de las API es poder facilitar el trabajo a los desarrolladores, permitiendo llevar a cabo la conocida reutilizacion de recursos/software.
#### Ejemplo de utilizacion:
Supongamos que estas creando una aplicaicon que es una tienda online, utilizando APIS, no necesitariamos crear desde cero un sistema de pagos, 
para recibir los pagos de las compras de los clientes. Tranquilamente podrias utilizar la API de un servicio de pago ya existente, por ejemplo MercadoPago o PayPal.

# Creacion de una API con Spring Boot
- Se crea una clase Java llamada HelloRestController y vamos a asignarla como nuestro controlador mediante la Annotation @RestController
- Dentro de la clase vamos a crear el metodo sayHello() que va a devolver un String "Hello World".
- A este metodo vamos a etiquetarlo con la annotation @GetMapping, la cual nos indica que cuando nuestra API reciba una solicitud GET mediante el protocolo HTTP, debe devolver el resultado del metodo sayHello().
- Una vez hecho esto, vamos a ejejcutar nuestra aplicacion y probar nuestro navegador llamamndo a la URL de nuestra aplicacion para corroborar que recibamos respuesta de sayHello().
- Generalmente la URL por defecto es localhost:8080
- Es importante verificar en que puerto SpringBoot levanta nuestra aplicacion. por defecto este siempre sera 8080.
```java
@RestController
public class HolaRestController{
    
    @GetMapping
    public String sayHello(){
        return "Hello World";
    }
}
```
## Parametros con Spring Boot

- Un @GetMapping puede recibir diferentes parametros que luego podemos utilizarlos dentro de las funciones que declaremos.
- Para ello, vamos a modificar nuestro @GetMapping para indicar de que manera recibiremos el parametro.
- Luego agregaremos en sayHello() la recepcion del mencionado parametro. tener en cuenta: el nombre de la variable que recibira sayHello debe ser el mismo que el del parametro.

```java
@GetMapping ("/{name}")
public String sayHello(@PathVariable String name){
    return "Hello World";
        }

```
- Ahora completamos nuestro "Hello World" agregando el nombre que recibiremos por parametro desde el navegador.
```java
@GetMapping ("/{name}")
public String sayHello(@PathVariable String name){
    return "Hello World" + name;
        }

```

- Luego, ejecutamos nuestra aplicacion y desde el navegador pasamos un nombre cmo parametro a ver si funciona correctamente.
Con esto le enseñamos a Sprinng a interpretar la URL y como que se utilicen los parametros.

## Diccionario Resumen de Anotaciones de esta clase:

- @SpringBootApplication: Nos permite especificar que trabajamos sobre una aplicacion de Spring Boot. Habilita 3 caracteristicas, la autoconfiguracion del proyecto (@EnableAutoConfiguration), la busqueda de componentes / paquetes de la aplicacion (@ComponentScan) y la posibilidad de realizar configuraciones extras (@Configuracion).
- @RestController: Anotacion para identificar  el controlador de un servicio de tipo REST
- @GetMapping: Anotacion para mapear las peticiones dmediante el metodo GET dentro de nuestra aplicacion.
- @GetMapping + @PathVariable: Anotacion parsa indicar el parametro que vamos a recibir en nuestro metodo

# Postman 

Postman es una herramient que nos permite simular un entorno frontendpara realizar diferentes pruebas en las API's que desarrollemos.

# Arquitectura REST y Metodos HTTP

Rest es un estilo arquitectonico que define un conjunto de buenas practicas, estandares y propiedades que se pueden inplementar sobre el Protocolo HTTP.

## Arquitectura REST
Transferencia de Estado Representacional (REST) es un estilo arquitectonico que define un conjunto de buenas practicas, estandares y propiedades que se pueden inplementar sobre el Protocolo de Transferencia de Hipertexto HTTP. Un servicio Web que se 
ajusta a los estandares REST permite la interoperabilidad entre dispositivos en internet.

Los servicios web RESTful permiten que los dispositivos cliente produzcan y consuman
recursos web, que se representan mediante el uso de texto con un conjunto uniforma 
y predefinido de operaciones sin estado.

Tim Berners-Lee definio los recursos web como parte de la World Wide Web (WWW) como recursos / documentos identificados por un localizador Uniforme de Recursos (URL).

## Metodo HTTP

Los metodos http definen la accion que se realizara sobre un determinado recurso. los metodos HTTP, tambien suelen ser llamados HTTP Verbs.
Aunque el nombre correcto es Verbs, la realidad es que en la practica, casi siempre son llamados "metodos", por lo que 
utilizaremos el nombre "metodos" para referirnos a ellos.

Entender  los metodos HTTP es fundamental para comprender la forma en que funciona la arquitectura REST, pues mediante los
metodos le indicamos al servidor la forma en que debe tratat una determinada peticion, dicho esto, una misma URL
puede ser tratada de diferente forma por el servidor.

HTTP define una gran cantidad de metodos que son utilizados para diferentes circunstancias, por lo que trataremos de mostrar lo mas reelevantes y mas utilizados en la construccion
de sevicios REST, los metodos son los siguientes:

| Metodo | CRUD             | Utilizacion                                                                                        | ¿Soporta envio de Payload? |
|--------|------------------|----------------------------------------------------------------------------------------------------|----------------------------|
| Get    | Read             | Para consumir informacion del servidor                                                             | NO                         |
| POST   | Create           | Para solicitar la creacion de un nuevo registro, es decir, algo que no existia previamente.        | SI                         |
| PUT    | Update / Replace | Para actualizar por complelto un registro existente.                                               | SI                         |
| DELETE | Delete           | Para eliminar un registro existente.                                                               | NO                         |
| PATCH  | Update / Modify  | Para cuando es necesario actualizar solo un fragmento / parte de un registro pero no su totalidad. | SI                         |

## Arquitectura REST

### Anotaciones en el Controlador

Cuando se realizan solicitudes en una API Mediante algun metodo HTTP para obtener algun resultado en particular,
es comun que necesitemos enviar ciertos datos en forma de parametro para poder de alguna manera "filtrar" o "acotar" la informacion que recibamos como respuesta.

Para poder manejar la correcta recepcion de estos parametros, Spring cuenta con una serie de 
anotaciones.

#### Multiples parametros con @GetMapping

El controlador es el artefacto central de nuestro servicio REST

Es un metodo dentro de un controlador podermo recibir tanto parametros como lo que sea
necesario.

Tomando como ejemplo un Hello World, si se desea obtener por parametro ademas el nombre
y la edad, hariamos lo siguiente:


```java
public class HelloRestController{
    
    @GetMapping (path = "{name}/{lastname}/{age}")
    public String sayHello(@PathVariable String name,
                           @PathVariable String lastname,
                           @PathVariable Integer age){
        
        return "Hello World" + name + " " + lastname + " Tu edad es: " + age ;
        }
}
```

## @PathVariable

- Es una anotacion que permite extraer informacion que es parte de la estructura de la URI, pero que no se trata como un par nombre = valor.
- Tal como lo dice su nombre, es "variable" por lo que el valor que sea ingresado en la URI sera el que se asigne a la variable mapeada con esta notacion.

```java
@GetMpping ("/user/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        // Codigo
        return new User(userId);
        }
```

## @Request Param

- Es una anotacion que permite recibir parametros desde una ruta mediante el metodo GET, para trabajar con ellos e incluso poder emitir una respuesta que dependa de los parametros que sean obtenidos.
- Cada uno de los parametros generalmente se ubican en la URL despues de un signo de pregunta "?" y estan anidados por un "&"-
- por ejemplo: http://localhost:8080/student?name="Horacio"&lastname="Quiroga"
```java
    
    @GetMapping (path = "/student/")
    public Student findStudent(@RequestParam String name,
                           @RequestParam String lastname){
        return findStudent(name, lastname);
        }
```

## @PathVariable VS @RequestParam

| @PathVariable                                                   | Columna 2                                                                                          |
|-----------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| Se usa para recuperar valores de la propia URI                  | Se usa para recuperar parametros de consulta. Los obtiene identificandolos luego del "?" en la URL |
| Forma de la peticion: http://localhost:8080/employee/Juan/Lopez | Forma de la peticion: http://localhost:8080/employee?name=Juan&lastname=Lopez                      |

## Multiples parsametros con el metodo POST

La notacion @PostMapping se usa para mapear solicitudes HTTP POST en metodos de controlador.
Es una alternativa de:
@RequestMapping(method = RequestMethos.POST)

Los metodos anotados con @PostMapping Manejan las solicitudes HTTP POST que coinciden con una URI determinada.

Ejemplo: Tenemos nuestra clase EMployee y creamos un metodo que por ejemplo, agrega un nuevo empleado.

```java
    @RestController
    @RequestMapping ("/")
    public class HelloRestController(path = "/employee") {
    @PostMapping(path = "/employee")
    public void addEmployee(@RequestBody Employee employee) {
        //Demas codigo
        return findStudent(name, lastname);
    }
}
```

## Payload en el metodo POST 
- Como parte de una solicitud POST o PUT, se puede enviar una carga util -o mejor conocida  por su palabra en ingles payload- de datos al servidor en el cuerpo (body) de la solicitud-
- El contenido del cuerpo puede ser cualquier objeto JSON valido. por ejemplo:

```java
{
        "firstname": "Charly",
        "lastname": "Brown",
        "username": "charlyb",
        "email": "charlyb@digitalhouse.com"
}
```

## RequestBody 
Se utiliza para vincular una solicitud HTTP (HTTP REQUEST) con un objeto en un parametro en un metodo de nuestro controlador.
La anotacion @RequestBody asigna el cuerpo de la solicitud HTTP a un objeto de dominio, lo que permite
la deserializacion automatica del cuerpo de la solicitud HTTP entrante en un objeto Java.

Ejemplo: Tenemos una clase Employee y creamos un metodo que haga algo con el utilizando @RequestBody
```java
    public class Employee{
    
    private Long id;
    private String name;
    private String lastName;
}
```
```java
@RestController
@RequestMapping ("/")
public class HelloRestController{
    @PostMapping(path = "/employee")
    public void handle(@RequestBody Employee employee) {
        //Demas codigo
        return findStudent(name, lastname);
    }
}
```

## ResponseBody
- Es una anotacion que es utilizada para indicar el contenido de una respuesta HTTP (response ) dentro del cuerpo de la misma.
- Una respuesta HTTP no puede contener objetos Java, por lo que @ResponseBody se encarga de transformar esa lista de objetos en un json.
```java
    @GetMapping (path = "/orders/")
    @ResponseBody
    public List<Order> getOrders(){
        return ordersManager.getAllOrders();
        }
```
## JSON
JSON es un formato de texto sencillo para el intercambio de datos y sin dudas uno de los más utilizados en las aplicaciones web.

JSON = JAVA-SCRIPT-OBJECT-NOTATION
El formato de un JSON es el siguiente 
- Los objetos: Estan representados mediante llaves, su apertura indica el comienzo de la estructura de un objeto y el cierre su final
- Sus valores intrinsecos: Los mismos representan mediante claves y valores.
  - Las claves deben ser cadenas de caracteres y representan el "nombre" del valor.
  - Los valores son tipos de datos soportados por JSON.
- Las claves y calores se separan entre si mediante ":"
- En caso de necesitar agregar mas claves y valores, se separan entre si mediante : ","

EJEMPLO:
```JSON
{
        "firstname": "Charly",
        "lastname": "Brown",
        "username": "charlyb",
        "email": "charlyb@digitalhouse.com"
}
```
En este ejemplo representamos varios objetos por medio de un JSON:
```JSON
{
  "personajes": [
    {
      "nombre": "Harry Potter",
      "casa": "Gryffindor",
      "varita": {
        "madera": "Sauco",
        "nucleo": "Fénix",
        "longitud": 11.0
      },
      "edad": 17
    },
    {
      "nombre": "Hermione Granger",
      "casa": "Gryffindor",
      "varita": {
        "madera": "Vid",
        "nucleo": "Corazón de dragón",
        "longitud": 10.75
      },
      "edad": 18
    },
    {
      "nombre": "Ron Weasley",
      "casa": "Gryffindor",
      "varita": {
        "madera": "Saúco",
        "nucleo": "Pelos de unicornio",
        "longitud": 12.0
      },
      "edad": 18
    }
  ]
}

```
## Notaciones:
@PathVariable y @RequestParam son anotaciones utilizadas en Spring Framework para manejar parámetros en solicitudes HTTP, pero se utilizan en diferentes contextos y para propósitos distintos.

- @PathVariable:

    - Se utiliza para extraer valores de la URI (Uniform Resource Identifier), es decir, de la propia URL.
    - Es útil cuando necesitas obtener datos directamente de la URL, por ejemplo, al acceder a una parte específica de la ruta.
    - Ejemplo
```java
@GetMapping("/usuarios/{id}")
public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
// Lógica para obtener y devolver el usuario con el ID proporcionado
}

```
En este caso, la variable id se extraerá del segmento de la URL que sigue a "/usuarios/".

- @RequestParam:
  - Se utiliza para extraer parámetros de consulta de la URL. Los parámetros de consulta son aquellos que aparecen después del signo "?" en una URL.
  - Es útil cuando necesitas pasar datos como parte de la solicitud, generalmente mediante formularios o simplemente como parámetros de consulta en la URL.
  - Ejemplo
```java 

@GetMapping("/buscar")
public ResponseEntity<List<Usuario>> buscarUsuariosPorNombre(@RequestParam String nombre) {
    // Lógica para buscar y devolver usuarios con el nombre proporcionado
}

```
En este caso, el parámetro nombre se espera como parte de la URL de la solicitud, como en "/buscar?nombre=John".

En resumen, @PathVariable se utiliza para extraer valores de la URI, mientras que @RequestParam se utiliza para extraer parámetros de consulta de la URL. La elección entre ellos depende de cómo se estén enviando los datos en la solicitud y de dónde se encuentran esos datos (en la URL o como parámetros de consulta).


## Data Transfer Object (DTO) y Response Entity

### DTO (Data Transfer Object)
DTO es un patron de diseño que tiene como finalidad crear un objeto plano (POJO) con una seria de atributos
que puedan ser enviados o recuperados del servidor en una sola invocacion.

Permite: 
- Crear estructuras de dato sindependientes de nuestro modelo de datos, lo que nos permite crear cuantas "vistas" sean necesarias de un conjunto de tablas u origenes de datos.
- Controlar el formato, nombre y tipos de datos con los que transmitimos los datos para ajustarnos a un determinado requerimento.

Ademas:
- Si por alguna razon, el modelo de datos cambio (y con ello las entidades) el cliente no se afectara pues seguira recibiendo el mismo DTO.
- En nuestra aplicacion el DTO es un objeto Java utilizado para la transferencia de informacion.
- los DTO deben respetar la inmutabilidad , es decir, las instancias creadas no pueden ser modificadas una vez que su informacion ha sido definida.
- En Srping dentro del @RestController podemos retornar directamente un DTO y el framework se encarga de trnasformar el formato JSON y retornarlo.

Ejemplo: tenemos 2 entidades 'Customer' y 'Address' y queremos mapear los datos de ambas en un simple DTO que sera enviado a la vista:

```java
public class  Customer{
    
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    /** GETs and SETs/
}
```

```java
public class  Address{
    
    private Long id;
    private Customer customer;
    private String country;
    private String address;
    /** GETs and SETs/
}
```

- El DTO que contiene los datos del cliente (Customer) y su direccion (Adress) quedaria de la siguiente manera:
```java
public class  CustomerDTO implements serializable { // Implementa la interface Serializable
    
    private Long id;
    private String FullName;
    private String country;
    private String address;
}
```

Y podemos utilizarolo por ejemplo de esta manera en el controlador:

```java
@GetMapping(path="/{customerId}")
@ResponseBody
public CustomerDTO getCustomer(PatVariable Long customerId){
    Customer customer = new Customer();
    Address address = new Address();
    
    CustomerDTO customerDTO = new CustomerDTO():
    customerDTO.setAddress(address.getAddress());
    customerDTO.setCountry(addres.getCountry());
    customerDTO.setFullname(customer.getFirsname() + " " + customer.getLastname());
    customerDTO.setId(customer.getId());
    
    return customerDTO;
}
```

## Clase ResponseEntity<T>

- En ciertas circunstancias es necesario enviar respuestas HTTP desde el controlador hacia la vista. Sprint posee muchas formas para manejar esto, como por ejemplo @ResponesBody; otra de ellas es ResponseEntity
- Extiende o hereda de la clase HttpEntity y que agrega un HttpStatus codigo de estado, Normalmente usada en los servicios REST dentro de los metodos controladores.
- ResponseEntity maneja todas las respuestas HTTP incluyendo el cuerpo, cabecera y codigos de estado permitiendo total libertad a la hora de configurar la respuesta que se envia desde los endpoints.

Ejemplo:

Retorna como tipo de cuerpo un String, ademas entrega junto a la respuesta un codigo de estado 200 OK.
```java
@GetMapping("/hello")
ResponseEntity<String> hello () {
    return new ResponseEntity<>("Hello World", HttpStatus.OK);
        }
```
### DATA TRANSFER OBJECT (DTO)
#### Conceptos basicos 

Una de las problematicas mas comunes cuando desarrollamos aplicaicones, es diseñar la forma en
que la informacion debe viajar desde la capa de servicios(o desde el controlador) a las aplicaciones o capa de presentacion,
ya que muchas veces por desconocimiento o pereza, uilizamos las clases entidades para retornar los datos necesarios o incluso, 
tengamos que ir en mas de una ocacion a la capa de servicios a recuperar los datos requeridos.

El patron DTOtiene como finalidad crear un objeto plano con una serie de atributos que puedan ser enviados o recuperados del servidor en una sola
invocacion, de tal forma que un DTO puede contener informacion de multiples fuentes o tablas y agruparla en una clase simple.

#### Caracteristicas de un DTO

Si bien un DTO es simplemente un objeto plano, tiene que cumplir algunas reglas:

- Solo lectura: Dado que el objetivo de un DTO es utilizarlo como un objeto de transferencia ente el cliente y el servidor, es importante evitar tener operaciones de negocio o metodos que realicen calculos sobre los datos, es por elloque solo deberemos de tener los emtodos GET y SET de los respectivos atributos DTO.
- Serializable: Es claro que si los objetos tendran que viajar por la red, deberan poder ser serializables, pero no  hablamos solamente de la clase en si, sino que tambien todos los atributos que contengan el DTO deberan ser facilmente serializables.

Un error clasico en Java es, por ejemplo crear atributos de tipo Date o Calendar para transmitir la fecha
u hora, ya que estos no tienen una forma estandar para serializarse por ejempl en Webservices o REST.

## Entidades vs DTO

Un error muy frecuente es el hecho de utilizar clases de Entidad para la transmision de datos entre el cliente y el servidor.
Solo para entrar en contexto, las entidades son clases que representa al modelo de datos, o mapea directamente contra la tabla de la base de datos.
Dicho esto, las entidades son clases que fueron diseñadas para maperar contra la base de datos, no para ser una vista para 
una pantalla o serviciio determinado, lo que provoca que muchos de los campos no puedas ser 
serializables o no contengan todos los campos necesarios.

El hecho de que las entidades no contengan todos los atributos necesarios o que no sean serializables trae otros problemas,
como la necesidad de agregar mas atributos a las entidades con el unico objetivo de poder cubrir los requerimentos de transferencia de datos,
dejando de lado el verdadero proposito de la entidad, que es unicamente mapear contra la base de datos,
lo que va llevando lentamente a ir creando una mezcla entre entidad y DTO.


## ResponseEntity

### Conceptos Basicos

Con Srping, generalmente tenemos muchas formas de lograr el mismo objetivo, incluido el ajuste fino de las respuestas HTTP

### Clase ResponseEntit<T>

Extiende o hereda de la clase HtttpEntity y agrega un HttpStauts codigo de estado. Normalmente es usada en los servicios REST dentro de los metodos
de los controladores.

ResponseEnity maneja toda la respuesta HTTP incluyendo el cuerpo, cabecera y codigos de estado permitiendonos total liberta para configurar la respuesta que queremos que
se envie desde nuestros endpoints.

Gracias a que el tipo de parametro es generico podemos realizar lo siguiente.

```java
@GetMpping("/hola")
ResponseEntity<String> holaMundo(){
    return new ResponseEntity<>("Hola mundo desde una respuesta HTTP", HttpStatus.OK);
        }
```
Logrando retornar como tipo de cuerpo un String, ademas entregamos junto a la respuesta un codigo de estado 200 Ok.


Ahora podemos programar nuestro endpoint para que retorne un codigo 400 de peticion mala en cado de
ingresar un correo invalido:

```java
@GetMapping("/verificar/{correo}")
ResponseEntity<String> verificarCorreo(@PathVariable String correo){
    if(!EmailValidator.getInstance().isValid(correo)){
        return new ResponseEntity<>("Formato debe ser: ejemplo@correo.dominio",HTTPStatus.BAD_REQUEST);
        }
    return new ResponseEntity<>("Su correo es: " + correo, HttpStsatus.OK);
        }
```

Ademas podemos establecer la cabecera de la respuesta de la siguiente manera:

```java
@GetMapping("/cabecera/{cliente"})
ResponseEntity<String> cabeceraPerzonalizada(@PathVariable String cliente){
    
    HttpHeaders cabecera = new HtppHeaders();
    cabecera.add("Estado cliente", "Cliente" + cliente + ": habilitado");
    return new ResponseEntity<>("Bienvenido " + cliente, cabcera, HttpStatus.OK);
}
```
Finalmente, ResponseEntity provee dos clases anidadas de tipo interface: BodyBuilder y HeadersBuilder.ResponseEntity posee
un metodo estatico para poder acceder a estas interfaces.

Por ejemplo hola Mundo:

```java 
@getMapping("/holaMundo")
ResponseEntity<String> holaMundo2(){
    return ResponseEntity.ok("HolaMundo !");
        }
```

Para el cado de validacion de correo:

```java
@GetMapping("/verificarCorreo/{correo}")
ResponseEntity<String> verificarCorreo2(@PathVariable String correo){
    if(!EmailValidator.getInstance().isValid(correo)){
        return new ResponseEntity.badRequest().body("Error! Formato correcto: ejemplo@correo.dominio");
        }
    return ResponseEntity.status(200).body("Correo: " + correo);
        }
```
Por ultimo para realizar una cabecera personalizada:
```java
@GetMapping("/cabeceraCustomizada/{cliente}")
ResponseEntity<String> cabeceraPerzonalizada2(@PathVariable String cliente){
    
    return ResponseEntity.ok()
                         .header("Estado Cliente:", "Cliente " + cliente + ": habilitado")
                         .body("Bienvenido cliente: " + cliente);
}
```

### Alternativas 

 - @ResponseBody: En las aplicaicones clasicas de Spring MVC, los endpoints generalmente devuelven paginas HTML renderizadas. A veces solo necesitamos devolver los datos reales. En tales casos, podemos marcar el metodo del controlador con @RepsonseBody, y Spring trata el valor de resultado del metodo como el propio cuerpo de respuesta HTTP.
 - @ResponseStatus: Cuando un endpoint regresa con exito, Sprinf proporciona una respuesta HTTP 200 (OK). Si el endpoint arroja excepcion, Spinr busca un controlador de excepciones que indique que estado HTTP usar. Podemos marcar estos emtodos con @ResponseStatus y, por lo tanto, Spring regresa con un estado HTTO personalizado.
 - Manipular la respuesta directamente: Spring tambien nos permite acceder directamente al objeto javax.servlet.http.HttpServletResponse; solo tenemos que declararlo como argumento de metodo, como vemos en la siguiente imagen.

```java
@GetMapping("/manual"})
void manual(HttpServletResponse response) throws IOException{
    
    response.setHeader("Custom-Header", "foo");
    response.setStatus(200);
    response.getWriter().println("Hello world!");
}
```

# Arquitectura Multicapa 

- La arquitectura Multicapa plantea que un proyecto desarrollado en Spring tiene una determinada division en capas segun la funcion o tarea que cada una de ellas cumple.
- Generalmente esta division consta de 5 capas pero puede varias segun el proyecto.
  - Repository (Conocida tambien como DAO)
  - Entity (Conocida tambien como Model)
  - DTO
  - Service 
  - Controller

Capa de Interfaz -> Controller (REQUEST)
Capa de Negocio -> Service and DTOs
Capa de Acceso a Datos --> Repository o DAO and Exceptions
Capa de Infraestructura -> Entity.

- Repository (o DAO): Es la capa de persistencia de datos, Facilitan el trabajo con diferentes tecnologias de acceso como JDBC, Hibernate o JPA de manera consistente. Cada clase de repositorio debe estar marcada con la notacion @Repository
- Entity (o Model): Una entidad representa una tabla almacenada en una base de datos. Cada instancia de una entidad representa una fila en a tabla. Cada clase de entidad debe estar marcada por la notacion @Entity.
- DTO: Los objetos de transferencia de datos se utilizan para desacoplar la representacion de datos (la vista) de los objetoa del modelo.
- Service: En pocas palabras se encarga de contener la logica de negocio de la aplicacion. Cada clase de servicio debe marcarse con la anotcacion @Service.
- Controller: Encargada de atender una solicitud desde el momento en que es interceptada hasta la generacion de la respuesta y su transmision. Cada clase de controlador debe estar marcada con la anotacion @RestController.

## Estructura de un Proyecto 

- Cuando se crea un proyecto, la estructura del mismo debe representar la arquitectura multicapa que haya sido elegida.
- En particular, cada capa debe incluirse dentro de un paquete especifico y cada uno de ellos, debe tener el mismo nombre de la propia capa.
- Un ejemplo de la estructura de un proyecti en base a estos conceptos puede ser:

- src
    - main
      - java
      - com.mercadolibre.src
        - controller
        - dto
        - entity
        - repository
        - servce

## Annotations

En la mayoria de las applicaciones tenemos distintas capas como vimos anteriormente.

En cada capa tenemos beans. Para detectar estos beans automaticamente, Spring usa anotaciones de escaneo de classpath.

Luego registra cada bean en el ApplicationContext(Representa el contenedor de inverison de control).

Algunas de estas anotaciones son:

- @Component: Es un estereotipo generico para cualquier componente administrado por Spring
- @Service: Anota clases en la capa de servicio
- @Repository Anota clases en la capa de persistencia.

## @Repository

- Es una notacion de Spring que indica que la clase anotada es un repositorio.
- Un repositorio es un mecanismo para encapsular el comportamiento de almacenamiento, recuperacion y busqueda que emula una coleccion de objetos.
- Es una especializacion de la anotacion @Component que pemrite que la implementacion de clases se detecten automaticamente atraves de el escaneo de classpath.

Una ventaja de usar esta anotacion es que tiene habilitada la traduccion automatica de excepciones de persistencia. Cuando se unsa un
marco de persistencia como Hibernate, las excepciones nativas lanzadas dentro de las clases anotadas con @Repository se traduciran automaticamente a subclasdes de DataAccesExeption de Spring

## @Service

La logica de negocio de una applicacion feneralmente reside dentro de la capa de servicio, en una capa diferente, separada de la clase @RestController.

Usaremos la anotacion @Services para indicar que una clase pertenece a esa capa.

### Interfaces e Implementaciones
Una mejor prctica para poder separar las capas seria que la comunicacion entre ellas sea mediante interfaces y no clases concretas.
```java
public interface SportPersonService {
    public List<SportPersonDTO> findAll();
}
```

```java
@Service
public class SportPersonServiceImpl implements SportPersonService{
    @override
    public List<SportPersonDTO> findAll(){
        //Logica
    }
}
```

Esta practica permite poder cambiar las implementaciones sin la necesidad de modificar el RestController o quien utilice esta dependencia (Inversion de Control).

- controller
- dto
- entity
- repository
- service
    - SportPersonService
    - SportPersonServiceImpl

## Arquitectura  Multicapa Repaso

Cuando trabajamos con aplciaciones que queremos que sean mantenibles y donde las responsabilidades de cada una de las partes y tareas que se lleven a cabo
esten bien diferenciadas, es una muy buena practica utilizar una Arquitectura en capas.

Las arquitectura en multicapas nos permiten separar las responsabilidades de cada una de las partes
de nuestra aplicacion, simplificando muchisimo a la hora de hacer nuevas implementaciones o modificacions que sean necesarias.

En particular cada capa debe incluirse en un paquete en especifico. Cada uno de ellos debe
tener el mismo nombre de la propia capa. De esta forma, encontrar una clase se vuelve muy facil en intuitivo.
Al mismo tiempo, no habra dudas sobre donde ubicar una nueva clase.

Cabe destacar que no existe un modelo unico y dependiendo del proyecto tendremos mas o menos capas.

Por ahora vamos a incluir las siguientes capas:

- Repository: Tambien podemos encontrarla como DAO: es la capa de persistencia de datos.

## Lombok 
Es una herramienta que nos facilita mucho la creacion de constructores con todos los argumentos, sin ningun argumento y los setters y getters.

Solo debemos incluir las siguientes lineas de codigo:
```java
@AllArgsConstructor   // Nos da un constructor con todos los argumentos
@NoArgsConstructor // Nos da un constructor sin argumentos
@Data // Nos da todos los setters and getters, equals, to String ... etc.
@Getter
@Setter // Estas ultimas se pueden definir individualmente tambien


```
# Anotaciones IMPORTANTES

La arquitectura de multi capa nos dice que debemos contectar:

El controller con el servicio,

el servicio con el repositorio,

Y Bueno en el repositorio debemos hacer la logica, el codigo, lo que se debe hacer en general y responder al servicio.

Despues en el servicio recibimos un resultado y lo comvertimos a un DTO para pasarselo a nuestro controller.

En el controller unicamente devolvemos lo que nos paso el servicio en forma de DTO y pasamos un estatus de respuesta.

La forma para comunicarnos entre el controller y el servicio es creando una instancia del servicio dentro de nuestro controller.

Lo mismo hacemos para comunicar el servicio con el repositorio, creamos una instancia de el reposiotio dentro del servicio y usamos la notacion :

@Autowired
PersonaRepositoryImpl repository;

@Autowired
PersonaServiceImple service;




## Inversion of Control

La inversion de control se encarga de que, no sea el programador quien lleve el flujo de control de una aplicacion mediante lineas que desarrolle, sino que sea
el framework quien lo haga por el.

Un tema clave en Spring es el contenedor de inverison de control, que es compatible con la interfaz ApplicarionContext.
Spring crea este "espacio" en nuestra aplicacion donde se pueden colocar algunas instancias de objetos como grupos de conexion de bases de datos, clientes HTTP, etc.
Estos objetos, llamados beans, se pueden usar mas tarde en otras partes de la aplicacion, comunmente a traves de una interfaz para abstraer
su codigo de implementaciones especificas.

Un bean es un objeto que Spring administra en tiempo de ejecucion con el contenedor de Inversion de control.
Estos se crean y agregan a un "repositorio de objetos" para que puedan ser obtenidos mas tarde.

El mecanismo para hacer referencia a uno de estos beans desde el ApplicationContext en otras clases es lo que llamamos inyeccion de dependencia, y en Spring esto es posible a traves de la configuracion XML o anotaciones de codigo.

## Bean 

En Spring, los objetos que forman la columna vertebral de la aplicación y que son administrados por el contenedor de Inversión de control se denominan beans.


Un bean es un objeto que es instanciado, ensamblado y administrado por un contenedor de Inversión de control. 
icho de otra forma, un bean es simplemente uno de los muchos objetos de nuestra aplicación. 

## Contenedor de Inversión de control Spring

La interfaz org.springframework.context.ApplicationContext representa el contenedor de Inversión de control y es responsable de crear instancias, configurar y ensamblar los beans.

El contenedor obtiene sus instrucciones sobre qué objetos instanciar, configurar y ensamblar leyendo los metadatos de configuración. 
Los metadatos de configuración se representan en XML o a través de las anotaciones.

### Inversión de Control (IoC)

Es un concepto también conocido como principio de Hollywood: “No nos llames, nosotros te llamamos”.
El objeto cede el control a alguien más (puede ser al propio framework u otros objetos).
Se implementa utilizando Inyección de Dependencias (DI). 

## Inyeccion de dependencias.

La Inyección de Dependencias (DI) es un patrón de diseño de software. Es una forma de implementar la Inversión de Control (IoC).

Su objetivo es tener un código lo suficientemente desacoplado que permita un fácil mantenimiento y escalabilidad.

Esta técnica permite que a un objeto se le provean las dependencias que necesite.

La inyección de dependencias (DI) es un proceso mediante el cual los objetos definen sus dependencias (es decir, los otros objetos con los que trabajan) solo a través de argumentos de constructor, argumentos a un factory method o propiedades que se establecen en la instancia del objeto después de que se construye o es devuelto de un factory method.

El contenedor de inversión de control luego inyecta esas dependencias cuando crea el bean. 

Este proceso es fundamentalmente el inverso (de ahí el nombre, Inversión de control) del propio bean que controla la instanciación o ubicación de sus dependencias por sí solo mediante la construcción directa de clases.

El código es más limpio con el principio DI y el desacoplamiento es más efectivo cuando los objetos cuentan con sus dependencias. 

El objeto no busca sus dependencias y no conoce la ubicación o la clase de las dependencias. Como resultado, sus clases se vuelven más fáciles de probar, particularmente cuando las dependencias están en interfaces o basadas en clases abstractas, lo que permite que las implementaciones mock para ser utilizadas en pruebas unitarias.

Existen dos variantes principales: inyección de dependencia basada en constructor e inyección de dependencia basada en Setter.

## Inyección de dependencia con @Autowired

Spring @Autowired es una de las anotaciones más habituales cuando trabajamos con Spring ya que se trata de la anotación que permite inyectar unas dependencias con otras.
Normalmente estamos acostumbrados a usar @Autowired a nivel de la propiedad que deseamos inyectar. 

Spring funciona como una mega fábrica de objetos. Cada clase se registra para instanciar objetos con alguna de las anotaciones @Controller, @Service, @Repository o @RestController.


Una vez que los objetos están creados, la anotación Spring @Autowired se encarga de construir las relaciones entre los distintos elementos.


Veamos un ejemplo (por ahora solo nos concentramos en cómo usar @Autowired):
Supongamos que tenemos una entidad Book, una clase BookRepository con un solo método que devuelve un listado de libros y un controlador que recibe una petición 
a través de la URL ‘/books’ y muestra el listado de libros.


# Repaso de Excepciones.

## Exception Handler

Como programadores tenemos que asegurarnos de no enviar excepciones o pilas de errores a los clientes. 
Los mensajes de excepción y error enviados deberán ser breves y significativos.

Por lo general, cuando nos enfrentamos a una situación inesperada en las API REST, 
automáticamente se arrojará un error HTTP como 404. Estos errores se mostrarán explícitamente en el navegador. 

Normalmente esto está bien; sin embargo, es posible que necesitemos un resultado en formato JSON independientemente de si las cosas funcionan bien o mal.

## Manejo de Excepciones con Spring Boot

El manejo de Excepciones es una parte importante de la construcion de una aplicacion solida.

Spring Boot ofrece mas de una forma de hacerlo. Nos proporciona herramientas para manejar excepciones
mas alla de bloques "try-catch". Para utilizar estas herramientas, aplicamos algunas anotaciones que nos permitan tratar
el manejo de excepciones de manera transversal:

- @ResponseStatus: vincula una exceocion particular a un estado de Restuesta HTTP especifico. ENtonces, cuando Spring detecta esa excepcion en particular, genera una respuesta HTTP con la configuracion definida en @ResponseStatus.
- @Response Status, marca iun metodo o clase de excepcion con el codigo de estado y el mensaje de motivo que debe devolverse. El codigo de estado se aplica a la respuesta HTTP cuando se invoca el metodo del controlador o siempre que se lanza la excepcion especificada.

Ejemplo en nuestro controlador dentro de un metodo, lanzamos una excepcion de un tipo que creamos nosotros (utilizando la palabra reservada throw)
cuando no se ingresa un id menor o igual a zero.

```java
public BookController (IBookService bookService){
    this.bookService = bookService;
}
@RequestMapping(values = "/book/{id}")
public String getBook(@PathVariable("id") long id){
    String message = "";
    
    if(id <= 0){
        message = String.format("Libro %d no encontrado", id);
        throw new BookNotFoundException(message);
        }
    message = String.format("Devolviendo el libro: %d", id);
    
    return message
}
```
Clase BookNotFoundException deonde utilizamos el @ResponseStatus.

```java
@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "No existe tal libro")
public class BookNotFoundException extends RintimeException{
    
    public BookNotFounException (String message){
        super(message);
    }
}
```

## ExceptionHandler
Esta anotación, como su nombre lo indica, proporciona una forma de definir 
métodos en un controlador en particular para manejar específicamente las excepciones 
lanzadas por dichos métodos.

El principal inconveniente de @ExceptionHandler es que los métodos anotados SOLO 
funcionarán para el controlador específico donde están definidos y 
NO para toda la aplicación.

Ejemplo: En nuestro controlador, creamos un método marcado con la anotación @ExceptionHandler, 
el cual recibe como parámetro una excepción del tipo que creamos, que devolverá 
el mensaje que le pasamos.

```java
@ExceptionHandler
public String handleBookNotFoundException(NookNotFoundException exception){
    return exception.getMesagge();
        }
```
Clase BookNotFoundException
```java
public class BookNotFoundException (String message){
    super(message);
}
```

## @ControllerAdvice: 
La anotación @ControllerAdvice nos permite consolidar nuestros múltiples 
@ExceptionHandlers dispersos de antes, en un solo componente global de manejo 
de errores. 

Nos da un control total sobre el cuerpo de la respuesta y sobre el código de estado.

Hace un buen uso de la respuesta ResposeEntity (en contraste con DefaultHandlerExceptionResolver 
que devuelve ModelAndView).

Es necesario hacer coincidir las excepciones declaradas con @ExceptionHandler con la excepción 
utilizada como argumento del método. Si estos no coinciden, ni el compilador ni Spring 
manifestarán nada en particular. Sin embargo, cuando la excepción se lanza en tiempo 
de ejecución, el mecanismo de resolución de excepciones fallará con:

- Ejemplo:  Creamos una clase anotada con @ControllerAdvice que maneja dos tipos de excepciones que nosotros creamos (NotFoundException y BadRequestException).

```java
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    @ExceptionHandler (NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStstus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler (BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e){
        return ResponseEntity.status(HttpStstus.BAD_REQUEST).body(e.getMessage());
    }
}
```

## ¿Que usar cuando?
Como de costumbre, a Spring le gusta ofrecer muchas opciones, entonces, 
dejamos algunas reglas generales:

- Para excepciones personalizadas, tenemos que considerar agregarles @ResponseStatus.
- Para el manejo de excepciones específicas del controlador, agregar los métodos @ExceptionHandler al controlador.
- Para todas las demás excepciones, implementar un método @ExceptionHandler en una clase @ControllerAdvice.
## NOTA:
Nota: tener cuidado al mezclar demasiadas de estas opciones en la misma aplicación. 
Si la misma excepción se puede aplicar de más de una forma, es posible que no se 
obtenga el comportamiento deseado. Los métodos @ExceptionHandler en el controlador 
siempre se seleccionan antes que los de cualquier instancia de @ControllerAdvice. 

## Spring Profile 

Cuando trabajamos en un proyecto que, por ejemplo, tiene diferentes versiones o funcionalidades dependiendo del ambiente 
en el cual se encuentra, sería ideal contar con una forma de diferenciar cada ambiente 
con un perfil o forma de trabajar distinta. Para esto, Spring nos provee de 
“Spring Profiles”.

#REVISAR ESTE TEMA CON MAS CALMA.

# TEST 

## Introduccion a la calidad de Software

Asegurar la calidad del software es primordial para entregar un producto que cumpla 
con los estándares y requisitos solicitados por nuestros clientes, pero… ¿Por qué?..
A continuación podrás comprender su importancia, así como los medios y recursos 
disponibles para alcanzarla.

## Testing 

La calidad de software es el grado con el cual un sistema, compoponente o proceso cumple con
los requerimentos y las necesidades o expectativas del cliente o usuario.

La calidad de software es medible y varia de un sistema a otro, o de un programa a otro.
Puede medirse despues de elaborado el producto, pero esto puede resultar muy costoso si se detectan
problemas derivados de imperfecciones en el diseño, por lo que es impresindible tener en cuenta tanto la obtencion de la calidad
como su control durante todas las etapas del ciclo de vida del software

Los requisitos de un sistema pueden ser funcionales (Que) o no funcionales (Como), el 
cumplimiento de estos requisitos nos permitira entender la calidad esperada por los usuarios desde enfoques
diferentes.

## ¿Como obtener un software de calidad?

La obtencion de un software de calidad implica la utilizacion de metodologias o procedimientos 
estandares para el analisis, diseño, programacion y prueba del software que permitan uniformar
la filosofia de trabajo, para lograr una mayor confiabilidad, mantenibilidad y facilidad de prueba,
a la vez que eleven la productividad, tanto para el desarrollo como para el control de la calidad de software.


En los modelos de calidad, la calidad se define de forma jerarquicsa y tienen como objetivo resolver la complejidad 
mediante la descomposicion.


### Control de calidad de software

Para controlar la calidad de software, es ncesaroip ante todo, definir los parametros, indicadores
o criterios de medicion. ya que no se puede controlar lo que no se puede medir.

Existen diversos estandares y modelos a considerar para evaluar la calidad de un software.
El modelo de calidad ISO/IEC se encuentra compuesto por 8 caracteristicas o dimensiones de
calidad.

- Adecuacion Funcional
- Confiabilidad
- Eficiencia de desempeño
- Usabilidad
- Seguridad 
- Compatibilidad
- Manteniabilidad
- Portabilidad

## Eficacia vs Eficiencia

- Eficacia: Busca el cumplimiento de un objetivo independientemente del numero de recursos empleados tiene que ver con QUE cosas se hacen
- Eficiencia: La eficiencia es hacer las cosas buscando la mejor relacion posible entre los recursos empleados y los resultdos obtenidos. Tiene que cer con el COMO se hacen las cosas
- Efectividad: Se refiere a hacer las cosas de forma eficiente y eficaz.


## Calidasd del COdigo

Los siguientes aspectos nos ayudarasn a medir la calidad de codigo siguiendo buenas practicas
adecuandonos a los estandares.

- Codigo duplicado
- Codigo Muerto 
- Estandares de codificacion
- Bugs
- Complejidad Ciclomatica
- Cobertura del codigo.

# INVESTIGAR SOBRE SonarQube

## Testing Automatizado VS Testing Manual

Como sabemos, existen diferentes roles para el testeo de software dentro de un 
equipo de desarrollo. Existen los testers manuales que se encargan de evaluar una 
aplicación a nivel funcional, tratando de imitar las posibles acciones que puede 
llevar a cabo un usuario.

Por otro lado, los desarrolladores tenemos la capacidad de realizar nuestros 
propios tests que se ejecuten de forma automatizada al mismo tiempo que nuestra 
aplicación, demostrando si la misma cumple con el comportamiento esperado.


## Validaciones

Validar los inputs del usuario es una práctica común y necesaria para evitar el ingreso de datos incorrectos que puedan comprometer el funcionamiento o estructura del sistema. Para esto existen diferentes librerías y frameworks disponibles para el lenguaje Java que te permitirán implementar esta lógica de una manera sencilla y práctica.

- El framework Java Bean Validation se ha convertidof en uno de los estandares mas utilizados para
implementar la logica de validaciones.


- Hibernate Validator es la referencia de implementacion de calidation API.
- JSR 380 permite expresiones dentro de mensajes donde ocurre un incumplimiento de validaciones.

# REVISAR ESTE TEMA DENUEVO.


# Introduccion a los Test unitarios

Niveles de Testing: 
- Pruebas Unitarias
- Pruebas de Integracion
- Pruebas de Sistema
- Pruebas de Aceptacion

Los test Unitarios son Test de componentes individuales, comprueba que cada unidad funciones correctamente por separado.

Los test de Intecacion son Test de componente integrados, prueba la interaccion entre las distintas partes del sistema.

### Test Unitario

- Un test unitario es la unidad mas pequeña de un sistema o aplicacion que puede ser testeado, permite probar cada modulo por separado.
- Asegura que cada modulo del programa funcione para lo que fue diseñado. Verifica que sean correctos los nombres y los tipos de datos de los parametros utilizados y lo que devuelven
- El objetivo de estas pruebas es comprobar el correcto funcionamiento de los componentes de un programa de manera individual(por ejemplo el testing de una funcion o de una clase de Java)
- Usualmente este tipo de testing es realizado por los desarrolldores, pero en la practica puedeser realizado por QAs (Quality Assurance)

### Actividad:
Dada la siguiente clase Java Identifica los comportamientos/ escenarios que podrias testear unitariamente:

```java
public class Calculator{
    public int calculateTotal(int a, int b){
        return a+ b;
    }
    public int calculateMinNumber(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
```
El metodo calculateTotal puede ser testeado unitariamente

El metodo calcularMinNumber puede suponer dos test unitarios ya que podemos comprobar que a sea menor que b y que be sea menor que a.

### ¿Por que realizamos test unitarios?

- Demuestran que la logica del codigo funciona correctamente en diferentes escenarios.
- Permiten identificar Bugs de manera temprana
- Sirven como documentacion del proyecto
- Aumentan la legibilidad y ayudan a entender el codigo base 
- Reducen los costos
- Se ejecutan en pocos segundos
- Mejoran el diseño y la calidad del codigo.(TDD).

### Las 3 A´s del unit testing

Para llevar a cabo buenas pruebas unitarias, deben ser estructuradas siguiendi un proceso compuesto por tres pasos.

- Arrange (Organizar) -> Se definen los requisitos que debe cumplir el codigo. 
- Act(Actuar) -> Llaga el momento de hacer la llamada al codigo que queremos probar, el cual dara lugar a los resultados a analizar.
- Assert(Afirmar) -> Es el momoento de comprobar si los resultados obtenidos son los esperados. Se valida que el componente a probar se comporte como lo habiamos previsto

Ejemplo: Funcion principal:

```java
public class Add{
    public int add (int a, int b){
        return a + b;
    }
}
    
```

test Unitario:
```java
public void addTest () {
    // Arrange
        int number1 = 3;
        int numbr2 = 5;
        int expectedResult = 8;
        Add addClass = new Add();
        //Act
        int result = addClass.add(number1, number2);
        
        //Assert
        assertEquals(expectedResult, result);
    }
}
    
```

## SUT - System Under Test

Cuando nos referimos a una porcion del sistema o codigo que estamos tetseando lo llamamos Sistema bajo prueba.

## ¿Como llevar a cabo pruebas nitarias?

Este proceso puede realizarse de manera manual, aunque lo mejor es automatizar el procedimiento a traves de herramientas. Existen muchas opciones disponibles que varian
en funcion del lenguaje de programacion.
- JUnit
- TestNG
- mockito

## Buenas practicas

- Las pruebas Unitarias deben ser independientes
- Siguen un esquema claro
- Cualquier cambio realizado necesita pasar el test
- Corrige BUgs identificados durante las pruebas antes de continuar
- Realiza pruebas regularmente mientras programas
- Escribe test claros evitando la repeticion de codigo y utilizacion innecesaria de recursos.


## Unit Test sin Mocks

Primer test unitario con JUnit 5

```java
public class Calculator{
    public int calculateTotal(int a, int b){
        return a+ b;
    }
    public int calculateMinNumber(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
```

Para esto vamos a basarnos en la clase Calculator donde identificamos algunos escenarios que podemos testear.

# Anotaciones en JUnit

- @Test -> Indica que el metodo es un metodo de test
- @ParameterizedTest -> Indica que se tarta de un metodo parametrizado, es decir, permite correr el test con multiples argumentos.
- @DisplayName -> Declara un nombre a mostrar customizado para la clase Test o metodo de test.
- @tag -> Se utiliza para declarar etiquets para filtrar tests. ya seas a nivel clase o de metodo. analogo a los test groups en TestNG o categorias en JUnit 4.
- @Disable -> Se utiliza para deshabilitar una clasede test o metodo de test analogo a @Igore de JUnit4

# Notaciones del ciclo de vida:

- @BeforeEach -> Ejecuta un metodo antes de cada @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, analogo a @Before de JUnit 4
- @AfterEach -> Ejecuta un metodo antes de cada @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, analogo a @After de JUnit 4
- @BeforeAll -> Ejecuta un metodo antes de todos los @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, analogo a @BeforeClass de JUnit 4
- @AfterAll -> Ejecuta un metodo despues de todos los @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, analogo a @AfterClass de JUnit 4

## Unit Test con MOcks

### Double or Fake (Doble o Impostor)

Test Double es un termino generico para cualquier caso donde se deba reemplazar un objeto de produccion con propositos de testing.

Tipos dobles de impostores:

- Dummy : SOn objetos que se utilizan para realizarse llamadas a otros metodos pero no se usan. Usualmente son utilizados para llenar listas de parameros.
- Stubs: Proveen respuestas enlatadas a llamadas reralizadas durante un test, se reprograman sus valores de retorno, los cuales seran constantes
- Spy: Solo un subconjunto de metodos son fake. A menos que explicitamente sean mockeados, el resto de metodos son reales.
- Mocks: Estan pre-programados con expectativvas que forman una especificacion de las llamdas que esperan recibir. Despues de terminada la prueba puede ser examinado para comprobar si las interacciones con el SUT han sido correctas, se pueden chequear si un metodo ha sido llamdo, o cuantas veces ha sido llamado.

## Mockito 

Es el framework de mocks mas conocido del mundo java. Perite crear y configurar objetos mock.

### Escribir un test unitario con mocks

- Anotar la clase con @ExtendWith(MockitoExtension.class) para inicializar los mocks e inyectarlos en donde se indique.
- @Mock permite mockear las dependencias de la clase
- Inyectar la dependencia mokeada mediante @InjectMocks
- Dentro del test definir el comportamiento del mock: when(methodCall).thenReturn(result)
- Ejecutar el metodo de la clase a testear
- Verificar que el metodo haya sido llamdo y retorne los valores que esperabamos.

```java
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepo;
    
    @InjectMOcks
    private UserService userService;
    
    @Test
    void testFindAllUsers(){
        List<UserDTO> expectedUsers = createUsersList();
        
        when(userRepo.findAll()).thenReturn(expectedUsers);
        
        List<UserDTO> currentUsers = userService.getAllUsers();
        
        verify(userRepo, atLeast(1)).findAll();
        assertThat(expectedUsers).isEqualTo(currenUsers);
        
    }
}
```