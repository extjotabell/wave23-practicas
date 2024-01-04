[MOVIES SQL]


Consultas a Base de Datos
// Práctica en clase


Ejercicio:

Se propone realizar las siguientes consultas a la base de datos movies_db.sql.
Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

- Mostrar todos los registros de la tabla de movies. 
- Mostrar el nombre, apellido y rating de todos los actores.
- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
- Mostrar los títulos de las primeras tres películas en la base de datos.
- Mostrar el top 5 de las películas con mayor rating.
- Listar los primeros 10 actores.
- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
- Mostrar a todos los actores cuyos nombres empiezan con Sam.
- Mostrar el título de las películas que salieron entre el 2004 y 2008.
- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.




[INTERNET PROVIDER QUERY]

Escenario


Una empresa proveedora de Internet necesita una base de datos para almacenar cada uno de sus clientes junto con el plan/pack que tiene contratado.
Mediante un análisis previo se conoce que se tiene que almacenar la siguiente información:
- De los clientes se debe registrar: dni, nombre, apellido, fecha de nacimiento, provincia, ciudad.
- En cuanto a los planes de internet: identificación del plan, velocidad ofrecida en megas, precio, descuento.

Ejercicio 1

Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación).


Ejercicio 2 

Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta

b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.


Ejercicio 3

Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar MySQL Workbench para ejecutar lo siguiente:
- Se solicita crear una nueva base de datos llamada “empresa_internet”. 
- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
- Realizar las asociaciones/relaciones correspondientes entre estos registros.


Ejercicio 4

Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.






