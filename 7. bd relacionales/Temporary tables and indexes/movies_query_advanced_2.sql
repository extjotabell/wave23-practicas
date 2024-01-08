USE movies_db;
SELECT * FROM movies;
SELECT * FROM genres;
SELECT * FROM actors;
SELECT * FROM copy_movies;

-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, null, null, 'Cuando acecha la maldad', 9.2, 3, '2023-12-12 00:00:00', 190, 2);

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, '2023-12-12 00:00:00', null, 'Catastrofes', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 47;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy_movies AS SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM copy_movies WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT
	genres.name
FROM 
	genres
JOIN 
	movies ON genres.id = movies.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT 
	actors.first_name, actors.last_name
FROM 
	actors
JOIN 
	movies ON movies.id = actors.favorite_movie_id
WHERE 
	movies.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_title_idx ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Dependiendo del campo sobre el cual se cree el index, por ejemplo, si creamos sobre el title, tiene muchas ventajas
-- hablando de rendimiento y velocidad, es muy común buscarlas por título.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía un índex sobre la tabla series, especificamente sobre el campo title, siguiendo la misma lógica que el 
-- punto anterior. Se mejoraría notablemente la performance, con la disminución de tiempo a la hora de las búsquedas.
