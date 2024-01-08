-- ---------------------------
-- Primera Parte
-- ---------------------------

-- 1. ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
	-- a. Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, 
	-- a partir de una o varias condiciones en común.

-- 2. Explicar dos tipos de JOIN.
	-- a. Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
	-- b. Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

-- 3. ¿Para qué se utiliza el GROUP BY?
	-- a. Agrupa los resultados según las columnas indicadas. 
	-- b. Genera un solo registro por cada grupo de filas que compartan las columnas indicadas.
	-- c. Reduce la cantidad de filas de la consulta.
	-- d. Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

-- 4. ¿Para qué se utiliza el HAVING? 
	-- a. La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
	-- b. Afecta a los resultados traidos por Group By.

-- 5. Escribir una consulta genérica para INNER JOIN Y LEFT JOIN:
SELECT movies.*, actors.first_name, actors.last_name 
FROM movies 
INNER JOIN actors ON movies.id = actors.favorite_movie_id;

-- ---------------------------
-- Segunda Parte
-- --------------------------- 

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name AS genre_name
FROM series
JOIN genres ON series.id = genres.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
INNER JOIN actor_episode  ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, MAX(seasons.number) AS total_seasons
FROM series 
INNER JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.id) AS total_movies
FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING total_movies >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT actors.first_name, actors.last_name
FROM actors 
INNER JOIN actor_movie ON actors.id = actor_movie.actor_id
INNER JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE '%Guerra de las galaxias%'
GROUP BY actors.id
HAVING COUNT(DISTINCT movies.title) = 
(SELECT COUNT(*) 
	FROM movies 
	WHERE movies.title 
	LIKE '%Guerra de las galaxias%'
);