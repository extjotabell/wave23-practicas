USE movies_db;
-- Responder las siguientes preguntas:

-- ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
-- Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.

-- Explicar dos tipos de JOIN.
-- Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
-- Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

-- ¿Para qué se utiliza el GROUP BY?
-- Agrupa los resultados según las columnas indicadas. 
-- Genera un solo registro por cada grupo de filas que compartan las columnas indicadas.
-- Reduce la cantidad de filas de la consulta.
-- Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

-- ¿Para qué se utiliza el HAVING? 
-- La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
-- Afecta a los resultados traidos por Group By.

-- Escribir una consulta genérica para cada uno de los siguientes diagramas: INNER JOIN / LEFT JOIN

SELECT movies.*, actors.first_name, actors.last_name 
FROM movies INNER JOIN actors 
ON movies.id = actors.favorite_movie_id;

SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;

-- Mostrar el título y el nombre del género de todas las series.
select title Serie, name Genero from series s join genres g on s.genre_id = g.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title Episodio, concat(a.first_name," ", a.last_name) Actor from episodes e join actor_episode ae on e.id = ae.episode_id join actors a on ae.actor_id = a.id;  
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select se.title Serie, count(s.title) as "Cantidad de temporadas" from seasons s join series se on s.serie_id = se.id group by serie_id;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select count(*) as Total , g.name Género from genres g join movies m on g.id = m.genre_id group by g.id having Total >= 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct concat(a.first_name," ", a.last_name) Actor from movies m join actor_movie am on m.id = am.movie_id join actors a on am.actor_id = a.id where m.title like "La Guerra de las galaxias%";

-- Mostrar las películas favoritas elegidas por los actores
select count(*) fav_mov, mo.title, mo.rating, mo.awards
from movies mo inner join actors ac
on mo.id = ac.favorite_movie_id
group by mo.id
order by fav_mov desc, mo.awards desc;

