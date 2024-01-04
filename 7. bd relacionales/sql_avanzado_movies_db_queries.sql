select title, g.name from series
join genres g on series.genre_id = g.id;

select e.title, a.first_name, a.last_name from actor_episode ae
join actors a on ae.actor_id = a.id
join episodes e on ae.episode_id = e.id;

select s.title, max(number) seasons from seasons
join series s on serie_id = s.id
group by serie_id;

select count(*) count, g.name from movies
join genres g on movies.genre_id = g.id
group by g.name;

select distinct a.first_name, a.last_name from actor_movie
join actors a on actor_movie.actor_id = a.id
join movies m on actor_movie.movie_id = m.id
where m.title like 'La Guerra de las galaxias%';
