-- Agregar una película a la tabla movies.
INSERT INTO movies
VALUES(22, null, null, "Rápido y furioso", 8.6, 1, '2001-11-17', 106,4);

-- Agregar un género a la tabla genres.
INSERT INTO genres
VALUES(13, '2024-05-01', null, "Policial", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET movies.genre_id = 13
WHERE movies.id = 22;