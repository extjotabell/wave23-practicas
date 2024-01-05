-- 1) Agregar una película a la tabla movies
INSERT INTO movies VALUES
(22, null, null, "A Star Is Born", 7.6, 1, "2018-08-31", 134, null);

-- 2) Agregar un género a la tabla genres
INSERT INTO genres VALUES
(13, "2023-01-08", null, "Romance", 13, 1);

-- 3) Asociar a la película del punto 1. genre el género creado en el punto 2
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 4) Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;

-- 5) Crear una tabla temporal copia de la tabla movies
CREATE TEMPORARY TABLE movies_tmp AS
SELECT * FROM movies;

-- 6) Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_tmp WHERE awards < 5;
SET SQL_SAFE_UPDATES = 1;

-- 7) Obtener la lista de todos los géneros que tengan al menos una película
SELECT DISTINCT g.*
FROM genres g, movies m
WHERE g.id = m.genre_id;

-- 8) Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT a.*
FROM actors a, movies m
WHERE a.favorite_movie_id = m.id AND
	  m.awards > 3;

-- 9) Crear un índice sobre el nombre en la tabla movies
ALTER TABLE movies
ADD INDEX idx_movie_title (title);

-- 10) Chequee que el índice fue creado correctamente
SHOW INDEX FROM movies WHERE Key_name = "idx_movie_title";

-- 11) En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta
-- Dependiendo los tipos de consultas que se realicen y la cantidad de registros que se tengan, crear índices
-- puede hacer que haya una mejora notable.
-- Por ejemplo, si tenemos 10.000 registros en la tabla movies y tenemos consultas recurrentes que acceden a dichos
-- datos por el id y genre_id, sería conveniente tener un índice por id y genre_id para que las consultas sean más
-- rápidas y eficientes.

-- 12) ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- La que dí en el ejemplo del punto anterior.