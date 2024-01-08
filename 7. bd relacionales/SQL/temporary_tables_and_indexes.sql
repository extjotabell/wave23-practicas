-- EJERCICIO 1

-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

DROP TEMPORARY TABLE IF EXISTS movies_db.TWD;

CREATE TEMPORARY TABLE TWD AS
SELECT episodes.*
FROM episodes
JOIN seasons ON seasons.id = episodes.season_id
JOIN series ON series.id = seasons.serie_id
WHERE series.title LIKE  '%The Walking Dead%';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT * FROM TWD;


-- EJERCICIO 2

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 

CREATE INDEX titulos ON movies(title);
SHOW INDEX FROM movies;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

-- Crear un índice en el campo title de la tabla movies nos permite ir directamente a la/s filas buscamos según el título,
-- sería como hacer un índice alfabético. El índice aquí se hace en el campo "title", 
-- porque suele ser la manera más común de buscar películas. 
-- Al igual que en un diccionario, donde buscas palabras, aquí, si buscas una película por su título, 
-- el índice te ayuda a encontrarla mucho más rápido y de forma eficiente.