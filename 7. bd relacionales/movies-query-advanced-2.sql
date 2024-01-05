USE movies_db;

--       Consultas SQL Avanzadas 2:

-- 1. Agregar una película a la tabla movies.

INSERT INTO movies VALUES (100,'2023-02-06 00:00:00',NULL,'Past Lives ',8.0,18,'2023-02-06 00:00:00',106,3);

select * from movies;

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13,'2000-02-06 00:00:00', NULL, 'Internacional', 13, 1 );

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 100;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors
SET favorite_movie_id = 100
WHERE actors.id = 10;

-- 5. Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE TemporaryMovies SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
-- (En caso de errror ejecutar -> SET sql_safe_updates = 0);
DELETE FROM TemporaryMovies
WHERE awards < 5 ;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT genres.name 
FROM genres 
INNER JOIN movies  ON genres.id = movies.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT actors.first_name AS Actor
FROM actors 
INNER JOIN movies  ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX movies_title  ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies_db.movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- No se considera necesario el index del id de pelicula favorita en la tabla actores, no es una consulta común.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía otro indice sobre la tabla seasons en título. De igual manera por release_date ya que pueden ser
-- consultas frecuentes y que no cambian. 

