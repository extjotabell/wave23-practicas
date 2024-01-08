USE movies_db;
#DROP TEMPORARY TABLE IF EXISTS TWD;

/*CREAR TABLA TEMPORAL
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios 
de todas las temporadas de “The Walking Dead”.
*/
CREATE TEMPORARY TABLE TWD
SELECT episodes.title AS 'Episode Title', episodes.release_date, seasons.title AS 'Season Title', seasons.number
FROM episodes
JOIN seasons ON episodes.season_id = seasons.id
JOIN series ON seasons.serie_id = series.id
WHERE series.title = "The Walking Dead";

SELECT * FROM TWD;

/*REALIZAR CONSULTA
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/
SELECT * FROM TWD WHERE number = 1;

/*INDICE
En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
*/
SHOW INDEX FROM actors;
EXPLAIN SELECT rating FROM actors WHERE rating > 6;
CREATE INDEX idx_rating ON actors(rating);
EXPLAIN SELECT rating FROM actors WHERE rating > 6;

/*ANALISIS
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- R: Analizando el resultado del explain, se ve una reduccion significante en el recorrido de filas reduciendo 36 a 22
-- Si rating es un potencial campo a  filtrar estarias reduciendo el costo de la consulta.
*/

