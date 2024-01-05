use movies_db;
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

drop temporary table TWD; 

-- con subconsulta 
create temporary table TWD
select * from episodes where season_id in 
(select ss.* 
from seasons ss 
join series s on ss.serie_id = s.id where s.title like "The walking dead");

select * from TWD;

-- con join
create temporary table TWD
SELECT ep.*, sea.number as temporada
FROM episodes ep
JOIN seasons sea ON ep.season_id = sea.id
JOIN series ser ON sea.serie_id = ser.id
WHERE ser.title = "The Walking Dead";

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

select * from TWD where temporada = 1;

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

SHOW INDEX FROM actors;
EXPLAIN SELECT rating FROM actors WHERE rating > 6;
-- Recorre 49 registros
CREATE INDEX idx_rating ON actors(rating);
EXPLAIN SELECT rating FROM actors WHERE rating > 6;
-- Recorre 22 registros

-- Como se suele filtrar muy seguido por rating es útil crear un index en ese campo, y al realizar consultas solo recorrerá los que
-- cumplan con el valor de filtrado


