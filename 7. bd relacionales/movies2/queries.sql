-- Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Inception', 8.8, 4, '2010-07-16', 148, 5);

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ('Sci-Fi', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 47;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS SELECT * FROM movies;
SELECT * FROM temp_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;

DELETE FROM temp_movies
WHERE awards < 5;

SELECT * FROM temp_movies;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.* FROM movies m
JOIN genres g ON m.genre_id = g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM movies m
JOIN actors a ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE UNIQUE INDEX title_index ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies WHERE title = 'Inception';
-- Ahora al hacer búsquedas sobre el campo title, se podrán indexar de manera mucho más rápida

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En general en las que tengan campos como name o title únicos, o en los que tienen que ver con personas podría ser un INDEX de nombre y apellido
