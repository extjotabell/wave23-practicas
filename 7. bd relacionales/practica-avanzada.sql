-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name
FROM series se
JOIN genres ge 
ON se.genre_id = ge.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, ac.first_name, ac.last_name
FROM actor_episode ae
JOIN episodes ep
ON ae.episode_id = ep.id
JOIN actors ac
ON ae.actor_id = ac.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title, COUNT(*) as total_seasons
FROM series se
JOIN seasons ss 
ON se.id = ss.serie_id
GROUP BY se.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name, COUNT(*) as total_movie
FROM movies mo
JOIN genres ge 
ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING total_movie >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name 
FROM actors ac
WHERE ac.id IN (
    SELECT am.actor_id
    FROM actor_movie am
    JOIN movies mo ON am.movie_id = mo.id
    WHERE mo.title LIKE "La Guerra de las galaxias%"
    GROUP BY am.actor_id
    HAVING COUNT(DISTINCT mo.title) = (SELECT COUNT(*) FROM movies WHERE title LIKE "La Guerra de las galaxias%")
);










