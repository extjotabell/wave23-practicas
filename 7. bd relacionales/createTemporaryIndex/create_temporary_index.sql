--  Creación de Tablas Temporales e Índices -- 
-- ----------------
-- Ejercicio 1
-- ----------------

-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT e.title AS episode_title, s.title AS season_title, se.title AS series_title
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

SELECT * FROM TWD;

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
 SELECT episode_title 
 FROM TWD
 WHERE season_title = 'Primer Temporada';
 
 
 -- ----------------
-- Ejercicio 2
-- -----------------
-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 

ALTER TABLE `movies_db`.`episodes` 
ADD INDEX `index_rating` (`rating` ASC);

-- Para quitar el índice
ALTER TABLE `movies_db`.`episodes` 
DROP INDEX `index_rating` ;
;

EXPLAIN SELECT rating 
FROM episodes 
WHERE rating > 8;

-- 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- -----------------
-- Cree un índice en rating, para que analizara de manera óptima los episodios con un rating mayor a 8. Pasando de 57 filas analizadas a 30 filas.
-- con el criterio de realizar consultas solo a la información requerida. Además es una información que se puede consultar de manera recurrente.
-- -----------------
