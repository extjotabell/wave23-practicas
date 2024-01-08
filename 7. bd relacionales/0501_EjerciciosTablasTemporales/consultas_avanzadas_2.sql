USE movies;

-- 1. Agregar una película a la tabla movies.
SELECT * FROM movies;

INSERT INTO movies VALUES (23, NULL, NULL, 'Evangelion 1.1', 8.2, 3, '2010-10-10', 134, 7);

-- 2. Agregar un género a la tabla genres.
SELECT * FROM genres;

INSERT INTO genres VALUES (14, NULL, NULL, 'Anime', 14, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 14 WHERE id = 23;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT * FROM actors;

UPDATE actors SET favorite_movie_id = 23 WHERE id = 32;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
	SELECT * FROM movies;
    
SELECT * FROM movies_copy;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
-- Desactivar el modo seguro
SET SQL_SAFE_UPDATES = 0;

DELETE FROM movies_copy WHERE awards < 5;

-- Activar el modo seguro de nuevo
SET SQL_SAFE_UPDATES = 1;


-- 7.Obtener la lista de todos los géneros que tengan al menos una película.
SELECT 
	* 
FROM 
	genres g 
JOIN movies m ON m.genre_id = g.id;

SELECT 
	g.name, 
    count(*) 
FROM 
	genres g 
JOIN movies m ON m.genre_id = g.id
GROUP BY 
	g.name;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id;

SELECT 
	a.* 
FROM 
	actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE 
	m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
SHOW INDEX FROM movies;

DESCRIBE movies;

CREATE INDEX title_index
ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- No debería existir una mejora notable debido a que ya existe uno ligado al id de la tabla.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- No debería ser necesario crear un índice en alguna otra table ya que casi todas cuentan con llave primaria. En el caso de password_resets
-- no sería tan importante ya que la información ahí almacenada no es tan prioritaria.
