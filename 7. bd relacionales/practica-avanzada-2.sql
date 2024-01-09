USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies
VALUES(22, null, null, "Rápido y furioso", 8.6, 1, '2001-11-17', 106,4);

-- Agregar un género a la tabla genres.
INSERT INTO genres
VALUES(13, '2024-05-01', null, "Policial", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET movies.genre_id = 13
WHERE movies.id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET actors.favorite_movie_id = 22
WHERE actors.id = 3;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE MoviesTemp AS
SELECT * 
FROM movies; 

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM MoviesTemp
WHERE MoviesTemp.awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT NAME FROM genres 
JOIN movies ON movies.genre_id = genres.id;

SELECT DISTINCT  genres.name
FROM genres
WHERE genres.id IN (
	SELECT movies.genre_id
    FROM movies
);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.*
FROM actors
JOIN movies ON movies.id = actors.favorite_movie_id
WHERE movies.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX inx_movies_name (title ASC) VISIBLE;

-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT title FROM movies WHERE title LIKE "Carrozas de fuego"; 

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta.

-- En cuanto al tiempo de ejecucion no se nota una mejora porque son pocos datos pero al ver la query con el explain
-- se ve que cuando tiene el index y tratamos de buscar el titulo con el like recorre solo un campo y si no esta el index
-- recorre todas. Para este ejemplo no hace falta un index porque no hay mucho volumen de dato en las tablas y los indices ocupan
-- memoria dentro de la BD que por ese motivo no se crean indices para todas las tablas, solo cuando hay una cantidad grande de registros
-- y se acceden con frecuencia.

