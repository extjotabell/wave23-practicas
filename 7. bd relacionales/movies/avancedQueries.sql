SELECT se.title serie, ge.name genre
FROM series se INNER JOIN genres ge
ON se.genre_id = ge.id;

SELECT e.title episode, CONCAT(a.first_name, " " , a.last_name) actor
FROM actors a INNER JOIN actor_episode ae
ON a.id = ae.actor_id INNER JOIN episodes e
ON e.id = ae.episode_id;

SELECT series.title serie, COUNT(*) number_seasons
FROM seasons INNER JOIN series
ON seasons.serie_id = series.id
GROUP BY series.id;

SELECT ge.name genre, COUNT(*) number_movies
FROM movies mo INNER JOIN genres ge
ON mo.genre_id = ge.id
GROUP BY ge.id
HAVING number_movies >= 3;

SELECT DISTINCT CONCAT(a.first_name, " " , a.last_name) actor
FROM actors a INNER JOIN actor_movie am
ON a.id = am.actor_id INNER JOIN movies m
ON m.id = am.movie_id
WHERE m.title LIKE "La Guerra de las galaxias%";