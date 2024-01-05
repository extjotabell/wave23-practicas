use movies_db;
set SQL_SAFE_UPDATES = 0;

insert into movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id) values (null,null, "Harry Potter y La Piedra Filosofal", 10, 2, "2010-10-04", 180,3);

insert into genres values (13, "2013-07-04", null, "Drama-Terror", 13, 1);

update movies set genre_id = 13 where title =  "Harry Potter y La Piedra Filosofal";

update actors set favorite_movie_id = 13 where id=1;

create temporary table moviesCopy select * from movies;

delete from moviesCopy where awards <5;

select * from genres where genres.id in (select genre_id from movies);

select * from actors where favorite_movie_id in (select id from movies where awards >3);

create index idx_title_movie on movies(title);

show index from movies;

-- Quizas en el campo genre_id para acelerar los joins y la busqueda de registros.

-- Crearia un indice en campos que permitan realizar joins con otras tablas, o campos que se utilicen para las busquedas frecuentemente como puede ser en seasons el campo serie_id por ejemplo.
