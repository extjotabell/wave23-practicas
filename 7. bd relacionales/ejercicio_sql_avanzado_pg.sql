select title, genres.name as genero from series
left join genres on series.genre_id = genres.id;

select first_name,last_name,title from actors
left join actor_episode on actors.id = actor_episode.id
left join episodes on actor_episode.id = episodes.id;

select series.title,count(serie_id) as numero_temporadas from series
left join seasons on series.id = seasons.serie_id
group by series.title;

select genres.name,count(title) as cantidad_peliculas from genres
left join movies on genres.id = movies.genre_id
group by genres.name
having count(title) >= 3;

select distinct actors.first_name,actors.last_name from movies
left join actor_movie on movies.id = actor_movie.movie_id
left join actors on actor_movie.actor_id = actors.id
where title like "La Guerra de las galaxias%";

