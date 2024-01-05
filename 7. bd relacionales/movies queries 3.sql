#Consultas SQL Avanzadas parte 2

#Agregar una película a la tabla movies.
INSERT INTO `movies2_db`.`movies`
(`id`,
`created_at`,
`updated_at`,
`title`,
`rating`,
`awards`,
`release_date`,
`length`,
`genre_id`)
VALUES
(22,
null,
null,
'Hunger Games',
8.0,
5,
'2012-03-23',
100,
5);

#Agregar un género a la tabla genres.
INSERT INTO `movies2_db`.`genres`
(`id`,
`created_at`,
`updated_at`,
`name`,
`ranking`,
`active`)
VALUES
(13,
null,
null,
'Thriller',
13,
1);

#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE `movies2_db`.`movies`
SET
`genre_id` = 13
WHERE `id` = 22;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE `movies2_db`.`actors`
SET
`favorite_movie_id` = 22
WHERE `id` = 1;

#Crear una tabla temporal copia de la tabla movies.
create temporary table movies2_db.movies_copy
(id int not null primary key,
 created_at timestamp,
 updated_at timestamp,
 title varchar(500) not null,
 rating decimal(3,1),
 awards int unsigned not null,
 release_date datetime not null,
 lenght int unsigned, 
 genre_id int unsigned
) (select * from movies);

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
select * from `movies2_db`.`movies_copy`;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies2_db.movies_copy WHERE awards < 5;

#Obtener la lista de todos los géneros que tengan al menos una película.
select distinct ge.* from genres ge
inner join movies on movies.genre_id = ge.id;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select ac.* from actors ac
inner join movies on movies.id = ac.favorite_movie_id
where movies.awards > 3;

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies_title ON movies(title);
DROP INDEX idx_movies_title ON movies;

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT * FROM movies2_db.movies where title like 'Hunger Games';
-- Sin indices, la query recorre los 22 registros existentes hasta encontrar las peliculas con el titulo Hunger Games.
-- Con el indice creado por title ya solo recorre un registro, mejorando la performance de busqueda.

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- A nivel negocio se debería ver cual es la tabla con mas consultas, y en esa agregaría indices para mejorar la performance de busqueda.






