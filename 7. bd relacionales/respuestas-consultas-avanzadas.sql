-- Agregar una película a la tabla movies.
INSERT INTO movies(created_at, updated_at,title,rating,awards,release_date,length, genre_id) 
values (now(),now(), 'TITULO', 1,0, now(),10,1);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at,name,ranking,active)
values (now(),now(),'Genero', 13,1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 where id = 22;
-- SELECT * FROM movies WHERE title = 'TITULO'

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 3;
-- SELECT * FROM actors WHERE id = 3

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE TMP_movies SELECT * FROM movies;
-- SELECT * FROM TMP_movies

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
-- SET sql_safe_updates = 0; SET FOREIGN_KEY_CHECKS=0;
DELETE FROM TMP_movies WHERE awards < 5 ;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres WHERE id in (SELECT genre_id FROM movies);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors WHERE favorite_movie_id in ( SELECT id FROM movies WHERE awards > 3);


-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_name ON movies(title);
-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;


-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
	R: Depende, de lo que se requiera hacer, cuales son las consultas mas frencuentes,
       porque si se empieza a crear index, las queries de actualizacion e inserción van a ser mas costosas
       y también requerirá de mas mantenimiento de los index.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

/*
	R: Crearía index en las tablas que tengan campos como fechas, titulo/nombre y rating 
		ya que creemos que esos campos serían potencialmente los mas buscados
*/














