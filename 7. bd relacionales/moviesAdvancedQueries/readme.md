# Consultas SQL Avanzadas
    Práctica individual
## Primera Parte

Responder las siguientes preguntas:

1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?

    a. Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar 
    datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.

2. Explicar dos tipos de JOIN.

    a. Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
    b. Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

3. ¿Para qué se utiliza el GROUP BY?
    a. Agrupa los resultados según las columnas indicadas. 
    b. Genera un solo registro por cada grupo de filas que compartan las columnas indicadas.
    c. Reduce la cantidad de filas de la consulta.
    d. Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

4. ¿Para qué se utiliza el HAVING? 
    a. La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
    b. Afecta a los resultados traidos por Group By.

5. Escribir una consulta genérica para cada uno de los siguientes diagramas:

![JOIN.png](https://github.com/extjotabell/wave23-practicas/blob/limpio_andres/7.%20bd%20relacionales/moviesAdvancedQueries/img/JOIN.png)

    SELECT movies.*, actors.first_name, actors.last_name 
    FROM movies INNER JOIN actors 
    ON movies.id = actors.favorite_movie_id;

    SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;


## Segunda Parte
Se propone realizar las siguientes consultas a la base de datos movies_db.sql trabajada en la primera clase.
Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

    1. Mostrar el título y el nombre del género de todas las series.
    2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
    3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
    4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
    5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

A modo de guía para el planteo de consultas, recordar el DER del escenario:
![DER movies.png](https://github.com/extjotabell/wave23-practicas/blob/limpio_andres/7.%20bd%20relacionales/moviesAdvancedQueries/img/DER%20movies.png)
