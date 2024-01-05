insert into movies values (100, NULL, NULL,'Shutter Island', 10, 1, '2010-10-04 00:00:00', 139, 5);

insert into genres values (150, '2016-07-04 03:00:00', NULL, 'Peliculas re buenas', 16, 16);

update movies set genre_id = 150 where id = 100;

select * from movies where id = 100;

update actors set favorite_movie_id = 100 where first_name = 'Leonardo' and last_name = 'Di Caprio';

create temporary table movies_copy select * from movies;

delete from movies_copy where awards < 5;

select g.name, count(g.name) as numberOfOcurrences from movies
left join genres g on movies.genre_id = g.id
group by g.name;

select a.first_name, a.last_name, m.title, m.awards from actors a
join movies m on a.favorite_movie_id = m.id
where m.awards > 3;

create index index_movies_title on movies (title);

show index from movies;


