CREATE TEMPORARY TABLE TWD (
    serie VARCHAR(255),
    temporada VARCHAR(255),
    capitulo VARCHAR(255)
);

INSERT INTO TWD (serie, temporada, capitulo)
select series.title, seasons.title,episodes.title from series
left join seasons on series.id = seasons.serie_id
left join episodes on seasons.id = episodes.season_id
where series.title = "The Walking Dead";

CREATE INDEX idx_email
ON users (email);

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies (title, release_date, length, awards,genre_id)
VALUES ('La pelicula', '2024-01-01', 120, 3,1);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (genre)
VALUES ('Adultos');

-- 3. Asociar a la película del punto 1 el género creado en el punto 2.
UPDATE movies
SET genre_id = 1
WHERE title = 'La pelicula';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie = 22
WHERE actor_id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp AS
SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT genre
FROM movies;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actor_name
FROM actors
WHERE favorite_movie IN (SELECT title FROM movies WHERE awards > 3);

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies_title ON movies (title);

-- 10. Chequear que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11 No existe una mejora significativa ya que son pocos datos.

-- 12 Crearía un indice en la tabla users ya que el mail es distinto para cada caso.
