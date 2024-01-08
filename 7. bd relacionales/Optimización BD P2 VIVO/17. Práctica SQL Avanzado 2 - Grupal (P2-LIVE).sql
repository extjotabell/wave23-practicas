-- 1. Agregar una película a la tabla movies.
SET @genreId = (SELECT id FROM genres WHERE name LIKE "Animacion"); 

INSERT INTO movies (title,rating,awards,release_date,length,genre_id)
VALUES ("La Bella y La Bestia", 8.5,3,'1991-11-22',84,@genreId);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (created_at,name,ranking,active)
VALUES(now(),"Genero Test",13,1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
SET @genreId = (SELECT id FROM genres WHERE name LIKE "Genero Test");
SET @movieId = ( SELECT id FROM movies WHERE title LIKE "La Bella y La Bestia");

UPDATE movies SET genre_id = @genreId WHERE id = @movieId;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SET @actorId = (SELECT id FROM actors WHERE first_name = "Emma" AND last_name = "Watson");
SET @movieId = ( SELECT id FROM movies WHERE title LIKE "La Bella y La Bestia");

UPDATE actors SET favorite_movie_id = @movieId WHERE id = @actorId;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE moviesTemp LIKE movies;
INSERT INTO moviesTemp SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM moviesTemp WHERE awards < 5;

SELECT * FROM moviesTemp;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT genres.name FROM movies LEFT JOIN genres ON movies.genre_id = genres.id;

-- Otra opción
SELECT genres.name
FROM movies 
LEFT JOIN genres ON movies.genre_id = genres.id 
WHERE movies.genre_id IS NOT NULL
GROUP BY movies.genre_id HAVING COUNT(movies.id) >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.* FROM actors LEFT JOIN movies ON actors.favorite_movie_id = movies.id WHERE movies.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX rating_idx ON movies (rating);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;