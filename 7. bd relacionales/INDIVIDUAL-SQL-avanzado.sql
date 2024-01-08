-- Consultas SQL Avanzadas - Individual

-- Primera parte
/* 
- ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
En una base de datos, se denomina JOIN a aquella cláusula que tiene como objetivo obtener datos de dos tablas que mantienen una relación entre sí. Esto nos permite tener información más completa desde dos orígenes distintos.

- Explicar dos tipos de JOIN
El JOIN más común es el INNER JOIN o JOIN, que me devolverá toda aquella información que mantenga un vínculo entre las dos tablas relacionadas.
El LEFT JOIN devolverá toda la información que mantenga un vínculo entre las dos tablas relacionadas de la consulta más todos aquellos registros que formen parte de la tabla que se indique del lado izquierdo.
Por ejemplo:
SELECT * FROM genres LEFT JOIN series ON series.genre_id = genres.id;
Me devolverá todos las series que tengan un género asignado y todos los géneros aunque no tengan ninguna serie registrada con el mismo.

- ¿Para qué se utiliza el GROUP BY?
El GROUP BY se utiliza justamente para agrupar los resultados de una consulta basado en la columna indicada. No tiene mucho sentido utilizarlo sí no se aplica en la consulta una función de agregación.

- ¿Para qué se utiliza el HAVING?
El HAVING se utiliza para filtrar los resultados obtenidos de una consulta que contenga un GROUP BY.

- Escribir una consulta genérica para cada diagrama:

INTERSECCIÓN: 
SELECT * FROM series INNER JOIN genres ON series.genre_id = genres.id;

DIFERENCIA A-B:
SELECT * FROM genres LEFT JOIN series  ON series.genre_id = genres.id;
*/

-- Segunda parte

/* Mostrar el título y el nombre del género de todas las series. */
SELECT series.title, genres.name AS 'genre'
FROM series INNER JOIN genres
ON series.genre_id = genres.id;

/* Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT episodes.title, actors.first_name, actors.last_name 
FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */ 
SELECT series.title, COUNT(*) AS 'total_seasons'
FROM seasons INNER JOIN series ON seasons.serie_id = series.id
GROUP BY serie_id;

/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3. */
SELECT genres.name AS 'genres', COUNT(*) AS 'total_movies'
FROM genres INNER JOIN movies
ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING COUNT(*) >= 3;

/* Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan. */
SELECT actors.first_name, actors.last_name FROM actors
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
WHERE actor_movie.movie_id IN (SELECT id FROM movies WHERE title LIKE 'La Guerra de las galaxias%');