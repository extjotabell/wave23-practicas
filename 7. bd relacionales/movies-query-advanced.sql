----- CONSULTAS ------

USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.

SELECT movies.title as title , genres.name as genrer
FROM movies
INNER JOIN genres ON movies.genre_id = genres.id
UNION
SELECT series.title, genres.name
FROM series
INNER JOIN genres ON series.genre_id = genres.id ;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actors.id = actor_episode.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT series.title, COUNT(seasons.id) as number_seasons
FROM series
INNER JOIN seasons ON  series.id = seasons.serie_id
GROUP BY series.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT genres.name, COUNT(*)  as total_movies
FROM genres
INNER JOIN movies ON movies.genre_id = genres.id
GROUP BY (genres.id)
HAVING total_movies >= 3
ORDER BY total_movies;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
INNER JOIN actor_movie ON actor_movie.actor_id = actors.id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title like '%La Guerra de las galaxias%';
