SELECT * FROM movies;

SELECT first_name, last_name, rating 
FROM actors;

SELECT title  as Titulo 
FROM series;

SELECT first_name, last_name, rating 
FROM actors 
WHERE rating > 7.5;

SELECT title, rating, awards 
FROM movies 
WHERE rating > 7.5 AND awards > 2;

SELECT title, rating 
FROM movies 
ORDER BY rating ASC;

SELECT title 
FROM movies 
LIMIT 3;

SELECT title, rating 
FROM movies 
ORDER BY rating DESC 
LIMIT 3;

SELECT * 
FROM actors
LIMIT 10;

SELECT title, rating 
FROM movies 
WHERE title LIKE "Toy Story%";

SELECT * 
FROM actors 
WHERE first_name LIKE "Sam%";

SELECT title , release_date
FROM movies
WHERE release_date BETWEEN "20040101" AND "20081231";

SELECT title, rating, awards
FROM movies 
WHERE awards > 1 
AND release_date BETWEEN "19880101" AND "20091231"
ORDER BY rating DESC 
LIMIT 3;

/* Consultas avanzadas*/
-- Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name 
FROM series INNER JOIN genres
ON series.genre_id = genres.id;

USE movies_db;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT title, first_name, last_name
FROM actors INNER JOIN
actor_episode 
ON actor_episode.actor_id = actors.id
INNER JOIN episodes 
ON actor_episode.episode_id = episodes.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(seasons.number) as temporadas
FROM series INNER JOIN
seasons
ON series.id = seasons.serie_id
group by series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, count(movies.genre_id) as peliculas
FROM genres INNER JOIN
movies
ON genres.id = movies.genre_id
group by genres.name
having peliculas >2;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT first_name, last_name, title
FROM actor_movie INNER JOIN
actors
ON actor_movie.actor_id = actors.id
INNER JOIN movies
ON actor_movie.movie_id = movies.id
WHERE movies.title like "La Guerra de las galaxias%";

/*Consultas avanzadas 2*/

-- Agregar una película a la tabla movies.
DELIMITER $$
CREATE PROCEDURE insertarpelicula (in in_title varchar(50), in in_rating decimal, in in_awards int, in in_release_date datetime, in in_length int, in in_genre_id int)
BEGIN
DECLARE exit handler for sqlwarning
START TRANSACTION;

insert into movies(title, rating, awards, release_date, length, genre_id)
values(in_title, in_rating, in_awards,  in_release_date,  in_length ,  in_genre_id);

COMMIT;
END$$
DELIMITER ;

call insertarpelicula("scooby doo", 7.5, 40, '2024-01-05 12:30:00', 10, 12);

-- Agregar un género a la tabla genres.
insert into genres(name, ranking)
values('aventura', 13);

select * from genres;

-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 13 
WHERE id = 2;

select * from actors;

-- Crear una tabla temporal copia de la tabla movies.
Create temporary table movies_db.moviesTemp select * from movies;
select * from moviesTemp;


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
Delete from moviesTemp where awards< 5; 

-- Obtener la lista de todos los géneros que tengan al menos una película.
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
-- Crear un índice sobre el nombre en la tabla movies.




