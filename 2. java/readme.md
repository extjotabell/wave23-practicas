TEMPERATURAS GLOBALES

Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron algunas ciudades del mundo durante el año pasado; a partir de estos registros, pudieron determinar la más baja y la más alta para cada una de las ciudades. Por ejemplo, se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C. Sin embargo, actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura máxima que hubo entre todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un vector con los nombres de cada una de las ciudades y una matriz de dos columnas que especifican su temperatura máxima y mínima, los cuales se especifican a continuación:

Vector Ciudades:
Londres
Madrid
Nueva York
Buenos Aires
Asunción
São Paulo
Lima
Santiago de Chile
Lisboa
Tokio


Matriz Temperaturas
-2, 33
-3, 32
-8, 27
4, 37
6, 42
5, 43
0, 39
-7, 26
-1, 31
-10, 35

Sabiendo que cada índice de fila representa a una ciudad. Se necesita conocer la mayor y la menor temperatura entre todas las ciudades; al mismo tiempo se deberá especificar el nombre de la ciudad. Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.






CARRERA DE LA SELVA

Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como “Carrera de la Selva”. El mismo se trata de una competición donde los mejores maratonistas y corredores de Latinoamérica se reúnen para desafiar sus habilidades deportivas.
La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una id, el nombre y una breve descripción:
Circuito chico: 2 km por selva y arroyos.
Circuito medio: 5 km por selva, arroyos y barro.
Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
Para poder conocer en qué categoría competirá cada participante se manejarán inscripciones. Cada inscripción debe contar con un número de inscripción, una categoría, un participante y el monto a abonar por el participante.

Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar los siguientes datos: número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo. 

Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen en cuenta los siguientes valores:

- Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
- Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
- Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que sea capaz de:

a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
c) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
e) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.






POO

EJERCICIO 1
Creá una clase Persona, la cual tendrá los siguientes atributos: nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres), peso y altura ¿Qué tipo de dato le asignarías a las variables de instancia? ¿Cómo sería la estructura básica de tu clase?

EJERCICIO 2 
Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, el segundo debe recibir como parámetro nombre, edad y dni; por último creamos un tercero que reciba todos los atributos de la clase como parámetro.

EJERCICIO 3
Creá una clase nueva llamada Main, donde declares un método main como te enseñamos anteriormente. Esto nos permitirá ejecutar nuestra aplicación.

EJERCICIO 4
En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees un objeto de tipo Persona por cada constructor que hayamos definido en la clase, recuerda poner un nombre significativo a las variables donde vas a asignar cada objeto. ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor. ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?

EJERCICIO 5
En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20, la función debe retornar -1, si devuelve un número entre 20 y 25 inclusive para los dos valores, el método debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1. Una vez creado el método anterior, agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano, teniendo en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años. Finalmente agregar un método toString() que va a devolver toda la información de la persona. 
¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.

EJERCICIO 6
Desde la clase Main vamos a calcular el IMC de la última persona que creamos (la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro). También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos, dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje acorde para el usuario. Finalmente queremos mostrar todos los datos de esa persona imprimiendo dicha información por consola. El formato en que vas a mostrar los datos y los mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien ve la salida del programa. 






POO2

EJERCICIO 1
1. Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int. Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”.
2. Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”.

EJERCICIO 2
Debemos entregar un trabajo para una distribuidora de productos, por lo que vamos a generar un programa que realice diferentes operaciones. Tendremos dos categorías de productos diferentes: Perecederos y No Perecederos.
1. Crear una clase Producto que cuente con los siguientes atributos: String nombre y double precio, la misma debe definir los métodos getters y setters para sus atributos, un constructor que reciba todos sus atributos como parámetro y el método toString(). Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.
2. Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, al igual que para el producto, definir setters, getters, constructor que reciba todos los atributos por parámetro y el método toString(). Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:
- Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
- Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
- Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.
3. Crear la clase NoPerecedero, la misma va a tener un atributo llamado tipo, el mismo va a ser un String, crear setters, getters, constructor y método toString(); en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase Producto.
4. Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.

