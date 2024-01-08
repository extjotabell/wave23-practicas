-- Consultas SQL Avanzadas 2

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
VALUES (22, NULL, NULL, 'One Piece RED Film', 9.4, 2, '2022-08-06 00:00:00', 115, NULL);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (id, created_at, updated_at, name, ranking, active)
VALUES (13, '2023-01-05 14:20:00', NULL, 'Anime', 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13 
WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

SET SQL_SAFE_UPDATES = 0;
UPDATE actors
SET favorite_movie_id = 22
WHERE first_name = 'Sigourney' AND actors.last_name = 'Weaver';
SET SQL_SAFE_UPDATES = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temporary_movies AS
SELECT * FROM movies;

SELECT * FROM temporary_movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temporary_movies
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT genres.name, COUNT(movies.genre_id) AS count_movie
FROM genres
INNER JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING COUNT(movies.genre_id) >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * 
FROM actors 
INNER JOIN movies 
ON movies.id = actors.favorite_movie_id
WHERE movies.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `index_movies_name` (`title` ASC) VISIBLE;
;

-- Para quitar el índice
ALTER TABLE `movies_db`.`movies` 
DROP INDEX `index_movies_name` ;
;

-- 10. Chequee que el índice fue creado correctamente.
EXPLAIN SELECT title 
FROM movies 
WHERE title = 'Parque Jurasico';

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Debido a la cantidad de registros, considero que la mejora es impercetible en segundos, pero con una cantidad de datos mas grandes la diferencia será notable.
No considero que sea necesario un index en el título de las películas, ya que parece una consulta poco común.
*/

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- -----------------
-- Crearía un índice en rating para la tabla episodes, para que analice de manera óptima los episodios con un rating mayor o menor a n cantidad deseada.
-- Se realizarían consultas solo a la información requerida y además es una información que se puede consultar de manera recurrente.
-- -----------------

