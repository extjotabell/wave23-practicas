/*Todos los registros de la tabla movies*/
select *
from movies;

/*Nombre, apellido y rating de todos los actores*/
select concat(first_name, " ", last_name) as name, rating
from actors;

/*Título de todas las series.*/
select title as titulo
from series;

/*Nombre y apellido de los actores cuyo rating es mayor a 7.5.*/
select concat(first_name, " ", last_name) as name
from actors
where rating > 7.5;

/*Título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.*/
select title, rating, awards
from movies
where rating > 7.5 and awards > 2;

/*Título de las películas y el rating ordenadas por rating en forma ascendente.*/
select title, rating
from movies
order by rating asc;

/*Títulos de las primeras tres películas en la base de datos.*/
select title
from movies
limit 3;

/*Mostrar el top 5 de las películas con mayor rating.*/
select title, rating
from movies
order by rating desc
limit 5;

/*Listar los primeros 10 actores.*/
select concat(first_name, " ", last_name) as name
from actors
limit 10;

/*Título y rating de todas las películas cuyo título sea de Toy Story.*/
select title, rating
from movies
where title like "%Toy Story%";

/*Todos los actores cuyos nombres empiezan con Sam.*/
select concat(first_name, " ", last_name) as name
from actors
where first_name like "Sam%";

/*Título de las películas que salieron entre el 2004 y 2008.*/
select title
from movies
where release_date between "2004-01-01" and "2008-12-31";

/*Título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009 ordenados los resultados por rating.*/
select title 
from movies
where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-12-31";



