/* 1- Agregar una película a la tabla movies. */

insert into movies_db.movies (title, rating, awards, release_date, length, genre_id) values ("Megamente", 4, 2, "1989-01-04 00:00:00", 120, 8);

/* 2- Agregar un género a la tabla genres. */

insert into movies_db.genres (name, ranking, active) values ("Romance", 34, 8);

/* 3- Asociar a la película del punto 1. genre el género creado en el punto 2. */

update movies_db.movies set genre_id = 14 where id = 22;

/* 4- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1. */

update movies_db.actors set favorite_movie_id = 22 where id = 1;

/* 5- Crear una tabla temporal copia de la tabla movies. */ 

create temporary table movies_copy as select * from movies_db.movies;
select * from movies_copy;

/* 6- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */ 

set SQL_SAFE_UPDATES = 0;
delete from movies_copy 
where awards < 5;
set SQL_SAFE_UPDATES = 1;

/* 7- Obtener la lista de todos los géneros que tengan al menos una película. */

select * from movies_db.genres
join movies_db.movies on movies_db.genres.id = movies_db.movies.genre_id
where movies_db.genres.id = movies_db.movies.genre_id;

/* 8- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards. */

select * from movies_db.actors
join movies_db.movies on movies_db.movies.id = movies_db.actors.favorite_movie_id
where movies_db.movies.awards > 3;

/* 9- Crear un índice sobre el nombre en la tabla movies. */

create index movie_name on movies_db.movies (title);

/* 10- Chequee que el índice fue creado correctamente. */

show index from movies_db.movies where key_name = "movie_name";
