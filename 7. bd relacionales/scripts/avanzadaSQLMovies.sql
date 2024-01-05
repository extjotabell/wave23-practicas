use movies_db;
-- 1
SELECT series.title, genres.name FROM series inner join genres on genres.id = series.genre_id;
-- 2
SELECT actors.first_name, actors.last_name, episodes.title
FROM actors INNER JOIN actor_episode on actor_episode.actor_id = actors.id
INNER JOIN episodes ON episodes.id = actor_episode.episode_id;
-- 3
SELECT series.title, COUNT(*) as quantity_seasons FROM seasons
INNER JOIN series ON seasons.serie_id = series.id GROUP BY serie_id;
-- 4
SELECT genres.name, count(*) as quantity_genre
FROM genres INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.id HAVING quantity_genre>=3;
-- 5
SELECT actors.first_name, actors.last_name FROM actors
WHERE actors.id IN
(SELECT actor_movie.actor_id FROM movies
INNER JOIN actor_movie ON actor_movie.movie_id= movies.id
WHERE movies.title LIKE "%La guerra de las galaxias%")
