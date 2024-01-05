-- Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
DROP TEMPORARY TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD (
    id INT PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR(500),
    number INT,
    release_date DATETIME,
    rating DECIMAL(3,1),
    season_id INT
);

INSERT INTO TWD SELECT ep.* FROM episodes ep
JOIN seasons se ON se.id = ep.season_id
JOIN series s ON s.id = se.serie_id
WHERE s.title = 'The Walking Dead';

SELECT * FROM TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT TWD.* FROM TWD
JOIN seasons se ON se.id = TWD.season_id
WHERE se.number = 1;