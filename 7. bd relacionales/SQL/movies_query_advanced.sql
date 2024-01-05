-- PRIMERA PARTE

-- ¿A qué se denomina JOIN en una base de datos y para qué se utiliza?
-- Se utiliza para obtener datos de varias tablas relacionadas entre sí. Consiste en combinar datos de una tabla con datos de la otra tabla, a partir de una o varias condiciones en común.

-- Explicar dos tipos de JOIN.
-- Inner Join se utiliza para traer los datos relacionados de dos o más tablas.
-- Left Join se utiliza para traer los datos de la tabla izquierda más los relacionados de la tabla derecha.

-- ¿Para qué se utiliza el GROUP BY?
-- Agrupa los resultados según las columnas indicadas. 
-- Genera un solo registro por cada grupo de filas que compartan las columnas indicadas.
-- Reduce la cantidad de filas de la consulta.
-- Se suele utilizar en conjunto con funciones de agregación, para obtener datos resumidos y agrupados por las columnas que se necesiten.

-- ¿Para qué se utiliza el HAVING? 
-- La cláusula HAVING se utiliza para incluir condiciones con algunas funciones SQL.
-- Afecta a los resultados traidos por Group By.

-- Escribir una consulta genérica para INNER JOIN Y LEFT JOIN:
SELECT movies.*, actors.first_name, actors.last_name 
FROM movies INNER JOIN actors 
ON movies.id = actors.favorite_movie_id;

SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;




-- SEGUNDA PARTE

-- Mostrar el título y el nombre del género de todas las series.
SELECT 
	series.title AS titulo, 
    genres.name AS genero
FROM 
	genres 
INNER JOIN 
	series ON genres.id = series.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT 
    episodes.title AS titulo,
    actors.first_name AS nombre,
    actors.last_name AS apellido
FROM 
    episodes
INNER JOIN 
    actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN 
    actors ON actor_episode.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT DISTINCT
	series.title AS titulo,
    COUNT(seasons.id) AS cantidad_temporadas
FROM 
    series
LEFT JOIN 
	seasons ON series.id = seasons.serie_id
GROUP BY 
	series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT
	genres.name AS genero,
    COUNT(movies.id) AS cantidad_total_peliculas
FROM 
	genres
LEFT JOIN 
	movies ON genres.id = movies.genre_id
GROUP BY 
	genres.name;
    
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT 
    actors.first_name AS nombre,
    actors.last_name AS apellido
FROM 
    actors
WHERE 
    actors.id 
    IN (
        SELECT DISTINCT actor_id
        FROM 
			actor_movie
        INNER JOIN 
			movies ON movies.id = actor_movie.movie_id
        WHERE 
            movies.title LIKE '%La Guerra de las galaxias%'
    );

