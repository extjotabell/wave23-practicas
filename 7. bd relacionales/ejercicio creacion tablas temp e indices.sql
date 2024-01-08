/* Ejercicio 1

1- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los 
episodios de todas las temporadas de “The Walking Dead”. Realizar una consulta a la tabla temporal para ver los 
episodios de la primera temporada. */

create temporary table TWD as 
select episodes.* 
from episodes
join seasons on episodes.season_id = seasons.id
join series on seasons.serie_id = series.id
where series.title = "The Walking Dead";

/* 2- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada. */
select * from TWD where season_id = 1;

/* Ejercicio 2

1- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. */

create index episode_title on movies_db.episodes (title);

show index from movies_db.episodes where key_name = "episode_title";

/* 2- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos. 

Crear un índice en una tabla puede mejorar significativamente el rendimiento de las consultas, especialmente 
cuando se trata de tablas grandes. Se sugiere indexar las columnas que se utilizan con frecuencia en cláusulas 
WHERE en consultas SELECT. También considera indexar las columnas utilizadas en cláusulas JOIN y ORDER BY si son 
relevantes para la aplicación. */

