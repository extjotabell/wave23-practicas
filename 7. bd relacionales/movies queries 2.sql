use movies2_db;

# Mostrar el título y el nombre del género de todas las series.
SELECT title, ge.name FROM movies2_db.series mo
INNER JOIN genres ge ON mo.genre_id = ge.id;

# Mostrar el título de los episodios, el nombre y apellido de los actores
# que trabajan en cada uno de ellos.
select title, ac.first_name, ac.last_name from episodes ep
inner join actor_episode ac_ep
on ep.id = ac_ep.episode_id
inner join actors ac
on ac_ep.actor_id = ac.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title as titulo, count(*) as cant_temporadas from series ser
inner join seasons sea
on ser.id = sea.serie_id
group by ser.title;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select ge.name as genero, count(*) as cant_peliculas from genres ge
inner join movies mo
on mo.genre_id = ge.id
group by ge.name
having cant_peliculas >=3;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct ac.first_name, ac.last_name from actor_movie ac_mo
inner join actors ac
on ac.id = ac_mo.actor_id
where ac_mo.movie_id in (SELECT id FROM movies where title like 'La Guerra de las galaxias:%');

