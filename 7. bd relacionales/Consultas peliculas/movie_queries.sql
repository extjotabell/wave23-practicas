SELECT * FROM movies;

SELECT first_name, last_name, rating 
FROM actors;

SELECT title  as Titulo 
FROM series;

SELECT first_name, last_name, rating 
FROM actors 
WHERE rating > 7.5;

SELECT title, rating, awards 
FROM movies 
WHERE rating > 7.5 AND awards > 2;

SELECT title, rating 
FROM movies 
ORDER BY rating ASC;

SELECT title 
FROM movies 
LIMIT 3;

SELECT title, rating 
FROM movies 
ORDER BY rating DESC 
LIMIT 3;

SELECT * 
FROM actors
LIMIT 10;

SELECT title, rating 
FROM movies 
WHERE title LIKE "Toy Story%";

SELECT * 
FROM actors 
WHERE first_name LIKE "Sam%";

SELECT title , release_date
FROM movies
WHERE release_date BETWEEN "20040101" AND "20081231";

SELECT title, rating, awards
FROM movies 
WHERE awards > 1 
AND release_date BETWEEN "19880101" AND "20091231"
ORDER BY rating DESC 
LIMIT 3;

/* Consultas avanzadas*/
SELECT series.title, genres.name 
FROM series INNER JOIN genres
ON series.genre_id = genres.id;

USE movies_db;

SELECT title, first_name, last_name
FROM actors INNER JOIN
actor_episode 
ON actor_episode.actor_id = actors.id
INNER JOIN episodes 
ON actor_episode.episode_id = episodes.id;


