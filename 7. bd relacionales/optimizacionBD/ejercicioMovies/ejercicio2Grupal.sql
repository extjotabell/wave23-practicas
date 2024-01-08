-- 1 Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (
'2024-01-10 12:30:00', 
'2024-01-10 12:30:00', 
'Rápido y Furioso: Alta Velocidad', 
8.5, 
3, 
'2023-07-15 18:30:00', 
140, 
1
);
SELECT * FROM movies;

-- 2 Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (
'2024-01-10 12:30:00', 
NULL, 
'Romance', 
13, 
1
);
SELECT * FROM genres;

-- 3 Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 4 Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 48;
SELECT * FROM actors;

-- 5 Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS SELECT * FROM movies;
SELECT * FROM movies_copy;

-- 6 Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
#SET sql_safe_updates = 0;
DELETE FROM movies_copy WHERE awards < 5;
SELECT * FROM movies_copy;

-- 7 Obtener la lista de todos los géneros que tengan al menos una película.
SELECT genres.name, movies.title FROM genres
JOIN movies ON genres.id = movies.genre_id;

-- 8 Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.first_name, movies.title, movies.awards
FROM actors
JOIN movies ON movies.id = actors.favorite_movie_id
WHERE movies.awards > 3;

-- 9 Crear un índice sobre el nombre en la tabla movies.
SELECT * FROM movies;
SHOW INDEX FROM movies;
CREATE INDEX movies_title_idx
ON movies (title);

-- 10 Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11 En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Crear un índice en la columna title de la tabla movies podría ofrecer mejoras notables en la velocidad de búsqueda, 
especialmente cuando se realizan consultas que involucran la condición WHERE basada en el título.
*/

-- 12 ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta.
/*
La creación de índices en una tabla se justifica en función del uso y las consultas que se realicen con frecuencia
sobre esa tabla en particular.
Por ejemplo, se podría crear un índice para optimizar búsquedas basadas en e rating de un actor. 
Este índice estaría asociado al campo "rating" en la tabla de actores (actors), permitiendo así 
consultas más eficientes y rápidas cuando se busca información relacionada con la valoración de los actores.
*/