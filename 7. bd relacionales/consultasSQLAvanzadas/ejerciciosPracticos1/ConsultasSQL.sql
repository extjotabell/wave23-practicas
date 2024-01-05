/*1 Mostrar el título y el nombre del género de todas las series*/
SELECT series.title AS titulo, genres.name
FROM series INNER JOIN genres
ON series.genre_id = genres.id;

/*2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos*/
SELECT title AS titulo, actors.first_name AS nombre, actors.last_name AS apellido 
FROM episodes
INNER JOIN actor_episode ON episodes.id= actor_episode.episode_id
INNER JOIN actors ON actors.id = actor_episode.actor_id;

/*3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas*/
SELECT series.title AS titulo, COUNT(*) AS cantidad
FROM series
INNER JOIN seasons ON seasons.serie_id = series.id
GROUP BY series.title;

/*4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3*/
SELECT genres.name AS genero, COUNT(genres.name) AS cantidad_totalPeliculas
FROM genres
INNER JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING cantidad_totalPeliculas >= 3;

/*5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan*/
SELECT consutaSelect.nombre, consutaSelect.apellido 
FROM 
( 
SELECT actors.first_name AS nombre, actors.last_name AS apellido, COUNT(actors.last_name) AS cantidad
FROM actors
INNER JOIN actor_movie ON actor_movie.actor_id = actors.id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE "La Guerra de las galaxias%"
GROUP BY actors.first_name, actors.last_name
) consutaSelect
WHERE cantidad >=1;
