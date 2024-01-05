-- Mostrar el título y el nombre del género de todas las series.
SELECT serie.title, genero.name FROM series as serie, genres as genero WHERE serie.genre_id = genero.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name 
FROM actors, episodes, actor_episode 
WHERE actor_episode.actor_id = actors.id AND actor_episode.episode_id = episodes.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(*) as "Total de temporadas"
FROM series, seasons
WHERE series.id = seasons.serie_id
GROUP BY series.title;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(*) as "Cantidad de peliculas"
FROM genres
JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING COUNT(*) > 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors a
WHERE NOT EXISTS (
    SELECT 1
    FROM movies m
    WHERE m.title LIKE '%Guerra de las galaxias%'
    AND NOT EXISTS (
        SELECT 1
        FROM actor_movie am
        WHERE am.actor_id = a.id AND am.movie_id = m.id
    )
)
GROUP BY a.id;