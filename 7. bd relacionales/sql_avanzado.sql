-- Active: 1704397818438@@127.0.0.1@3306@movies_db
-- 1
SELECT mov.title, gen.name
FROM movies mov
    INNER JOIN genres gen ON gen.id = mov.genre_id;
-- 2
SELECT
    epi.title,
    act.first_name
FROM episodes epi
    INNER JOIN actor_episode act_epi ON act_epi.episode_id = epi.id
    INNER JOIN actors act ON act.id = act_epi.actor_id;
-- 3
SELECT
    ser.title,
    COUNT(*) AS cantidad_temporadas
FROM series ser
    INNER JOIN seasons sea ON sea.serie_id = ser.id
GROUP BY title;
-- 4
SELECT
    gen.name,
    COUNT(*) AS cantidad_peliculas
FROM genres gen
    INNER JOIN movies mov ON mov.genre_id = gen.id
GROUP BY gen.name
HAVING cantidad_peliculas >= 3;
-- 5
SELECT
    DISTINCT act.first_name,
    act.last_name
FROM actors act
    INNER JOIN actor_movie act_mov ON act_mov.actor_id = act.id
    INNER JOIN movies mov ON mov.id = act_mov.movie_id
WHERE
    mov.title LIKE "%La Guerra de las galaxias%";