-- 1) Mostrar el título y el nombre del género de todas las series
SELECT s.title, g.name FROM series s, genres g WHERE s.genre_id = g.id;

-- 2) Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos
SELECT e.title, a.first_name, a.last_name
FROM episodes e, actor_episode ae, actors a
WHERE e.id = ae.episode_id AND
	  ae.actor_id = a.id;

-- 3) Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas
SELECT ser.title, count(*) temporadas
FROM series ser, seasons sea
WHERE ser.id = sea.serie_id
GROUP BY ser.title;

-- 4) Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3
SELECT g.name, count(*) cant_peliculas
FROM genres g, movies m
WHERE g.id = m.genre_id
GROUP BY g.name
HAVING count(*) >= 3;

-- 5) Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
-- Se puede escribir como:
-- Mostrar los actores donde no exista una pelicula de la guerra de las galaxias en la que no hayan trabajado
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
WHERE NOT EXISTS (
	SELECT m.id
    FROM movies m
    WHERE m.title LIKE "La Guerra de las galaxias:%"
    AND NOT EXISTS (
		SELECT am.id
        FROM actor_movie am
        WHERE am.movie_id = m.id AND
			  am.actor_id = a.id
		)
	);