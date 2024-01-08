select first_name, last_name, title as peliculas
from actors
inner join actor_movie on actors.id = actor_movie.actor_id
inner join movies on actor_movie.movie_id = movies.id
where movie_id in (select id from movies where rating > 9);

select movies.title, coalesce(genres.name, "Sin genero") as genero_pelicula
from movies
left join genres on movies.genre_id = genres.id;

select genres.name, avg(ranking) as average
from genres 
inner join series on genres.id = series.genre_id
group by genres.id
having avg(ranking) > 3.5; 

select title, (
select name_const()
from genres 
where id = movies.genre_id)
as genre_name 
from movies 
where genre_id = (
select id
from genres 
where name = "Musical");

/* -------------------------- */

use movies_db;

create table peliculas like movies;

create table peliculas2 select * from movies;

select movies.title, actors.first_name, actors.last_name
from movies inner join actors
on movies.id = actors.favorite_movie_id;

select * from actor_movie
where movie_id in (select id from movies where rating > 9);

select first_name as nombre, last_name as apellido, title as pelicula
from actors
inner join actor_movie on actors.id = actor_movie.actor_id
inner join movies on actor_movie.movie_id = movies.id
where actor_movie.movie_id in (select id from movies where rating > 7);

select movies.title, genres.name
from movies
inner join genres
on movies.genre_id= genres.id;

select movies.title as titulo_pelicula, coalesce(genres.name, 'Sin genero') as genero_pelicula 
from movies 
left join genres on movies.genre_id = genres.id;

select genres.name, avg(ranking) as avg_ranking
from genres
inner join series on genres.id = series.genre_id
group by genres.id
having avg(ranking) > 3.5;
;

select genres.name, count(series.id) as num_series
from genres
left join series on genres.id = series.genre_id
group by genres.id;

select title, (
	select name
    from genres
    where id = movies.genre_id
) as genre_name
from movies
where genre_id = (
	select id
    from genres
    where name = "drama"
);