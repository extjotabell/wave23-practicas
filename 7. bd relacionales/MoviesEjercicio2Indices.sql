INSERT INTO `movies`
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
"Saw",
8.0,
1,
"2008-06-10",
70,
2);

INSERT INTO `genres`
(`id`,
`created_at`,
`updated_at`,
`name`,
`ranking`,
`active`)
VALUES
(13,
"2024-05-01",
null,
"Policial",
13,
1);

UPDATE `movies` SET `genre_id` = '13' WHERE (`id` = '22');

UPDATE `actors` SET `favorite_movie_id` = '22' WHERE (`id` = '3');

CREATE TEMPORARY TABLE MoviesTemp AS
SELECT *
FROM movies;

select * from moviesTemp;

delete from moviesTemp where moviesTemp.awards < 5;

select distinct name from genres 
join movies on movies.genre_id = genres.id;
 
explain select first_name, last_name from actors
join movies on movies.id = actors.favorite_movie_id
where movies.awards > 3;

ALTER TABLE `movies` 
ADD INDEX `inx_movies_name` (`title` ASC) VISIBLE;

explain select title from movies where title LIKE "Carrozas de fuego"; 

-- En cuanto al tiempo de ejecucion no se nota una mejora porque son pocos datos pero al ver la query con el explain
-- se ve que cuando tiene el index y tratamos de buscar el titulo con el like recorre solo un campo y si no esta el index
-- recorre todas. Para este ejemplo no hace falta un index porque no hay mucho volumen de dato en las tablas y los indices ocupan
-- memoria dentro de la BD que por ese motivo no se crean indices para todas las tablas, solo cuando hay una cantidad grande de registros
-- y se acceden con frecuencia.