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
