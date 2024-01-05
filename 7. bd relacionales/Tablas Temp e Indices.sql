use movies2_db;

/*
Ejercicio 1
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/
create temporary table movies2_db.TWD
(id int not null primary key,
 created_at timestamp,
 updated_at timestamp,
 title varchar(500) not null,
 number int unsigned not null,
 release_date datetime,
 rating decimal(3,1),
 season_id int unsigned
) (select episodes.* from episodes
inner join seasons s on s.id = episodes.season_id
inner join series se on se.id = s.serie_id
where se.title = 'The Walking Dead');

select * from TWD;

/*
Ejercicio 2
En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
*/
EXPLAIN SELECT * FROM movies2_db.actors where last_name like 'Di Caprio';
-- Sin indices, la query recorre los 49 registros existentes hasta encontrar todos los actores con apellido Dicaprio.
-- Con el indice creado por last_name ya solo recorre un registro, mejorando la performance de busqueda.

SHOW INDEX FROM actors;

CREATE INDEX idx_actors_lastname ON actors(last_name);

DROP INDEX idx_actors_lastname ON actors;