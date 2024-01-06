USE movies_db;

CREATE TEMPORARY TABLE TWD AS
SELECT episodes.*
FROM episodes
JOIN seasons ON seasons.id = episodes.season_id
JOIN series ON series.id = seasons.serie_id
WHERE series.title = "The Walking Dead";

SELECT TWD.* 
FROM TWD
JOIN seasons ON seasons.id = TWD.season_id
WHERE seasons.title LIKE "Primer Temporada";

CREATE INDEX idx_genres_name ON genres(name);
SHOW INDEXES FROM genres;


-- Se creó el indice de name en genres para realizar más rápidas las busquedas sobre esta tabla que requiera saber el nombre del genero.
