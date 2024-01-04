USE movies_db;

-- 1. Mostrar todos los registros de la tabla de movies. 
SELECT * FROM movies;

-- 2. Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;

-- 3. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title as 'Título' FROM series as Serie;

-- 4. Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT 
	first_name, 
    last_name 
FROM 
	actors 
WHERE
	rating > 7.5;
    
-- 5. Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT
	m.title,
    m.rating,
    m.awards
FROM
	movies m
WHERE
	m.rating > 7.5
    AND m.awards > 2;
    
-- 6. Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT 
	m.title,
    m.rating
FROM
	movies m
ORDER BY
	m.rating ASC;
    
-- 7. Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT 
	m.title 
FROM 
	movies m 
LIMIT 3;

-- 8. Mostrar el top 5 de las películas con mayor rating
SELECT 
	* 
FROM 
	movies m 
ORDER BY 
	rating DESC 
LIMIT 5;

-- 9. Listar los primeros 10 actores.
SELECT 
	* 
FROM 
	actors a 
LIMIT 10;

-- 10. Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT 
	m.title, 
    m.rating 
FROM 
	movies m 
WHERE 
	m.title LIKE '%Toy Story%';
    
-- 11. Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT
	*
FROM
	actors a
WHERE
	a.first_name LIKE 'Sam%';
    
-- 12. Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT 
	m.title 
FROM 
	movies m 
WHERE 
	m.release_date BETWEEN '20040101' AND '20081231';
    
-- 13. Traer el título de las películas con el rating mayor a 3, 
-- con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. 
-- Ordenar los resultados por rating.
SELECT 
	m.title-- , m.rating
FROM 
	movies m 
WHERE 
	m.rating > 3 
    AND m.awards > 1 
    AND m.release_date BETWEEN '19880101' AND '20091231'
ORDER BY
	m.rating;


