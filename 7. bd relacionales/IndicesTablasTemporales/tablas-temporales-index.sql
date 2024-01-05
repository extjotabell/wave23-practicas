use movies_db;

-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- DROP TABLE TWD
CREATE TEMPORARY TABLE TWD 
SELECT 
    ep.title, ep.number, ep.release_date, ep.rating, ep.season_id, sea.number AS season_number
FROM
    episodes ep
        JOIN
    seasons sea ON ep.season_id = sea.id
        JOIN
    series ser ON sea.serie_id = ser.id
WHERE
    ser.title = 'The Walking Dead';
    
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT 
    *
FROM
    TWD
WHERE season_number = 1;
   /* season_id = (SELECT 
            sea.id
        FROM
            seasons sea
                JOIN
            series ser ON sea.serie_id = ser.id
        WHERE
            ser.title = 'The Walking Dead'
                AND sea.title = 'Primer Temporada');*/

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
SHOW INDEX FROM actors;
EXPLAIN SELECT rating FROM actors WHERE rating > 6;
CREATE INDEX idx_rating ON actors(rating)

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- R: Analizando el resultado del explain, se ve una reduccion significante en el recorrido de filas reduciendo 36 a 22
-- Si rating es un potencial campo a  filtrar estarias reduciendo el costo de la consulta.algorithm





