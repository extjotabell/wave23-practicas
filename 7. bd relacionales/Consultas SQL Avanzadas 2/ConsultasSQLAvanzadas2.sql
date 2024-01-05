-- Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Título de la Película', 8.5, 3, '2024-01-05 18:30:00', 120, 1);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Nombre del Género', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
-- Toca hacer uso de SQL_SAFE_UPDATES = 0 ya que title no es un índice, y esto NO es seguro.
SET SQL_SAFE_UPDATES = 0;

UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Nombre del Género')
WHERE title = 'Título de la Película';

SET SQL_SAFE_UPDATES = 1;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Título de la Película')
WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS
SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;

DELETE FROM temp_movies
WHERE awards < 5;

SET SQL_SAFE_UPDATES = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.id, g.name
FROM genres g
JOIN movies m ON g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Si la tabla movies es relativamente pequeña, la mejora en el rendimiento puede no ser significativa.
Con grandes volúmenes de datos, los índices pueden acelerar las operaciones de búsqueda y filtrado.
Las consultas que utilizan la columna indexada en cláusulas WHERE, ORDER BY o JOIN pueden beneficiarse de los índices.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
En la Tabla seasons, la creación de un índice en la columna title o number podría ser beneficioso si estas columnas se 
utilizan en consultas frecuentes y la tabla es lo suficientemente grande para justificar el costo de mantener el índice.
Podrían realizarse consultas como las siguientes:
*/
-- Consulta con índice en title
SELECT * FROM seasons WHERE title = 'Nombre de la Temporada';

-- Consulta con índice en title con ordenamiento
SELECT * FROM seasons ORDER BY title;

-- Consulta con índice en title con filtrado y ordenamiento
SELECT * FROM seasons WHERE serie_id = 1 ORDER BY title;

