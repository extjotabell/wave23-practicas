-- Ejercicio 1 --

CREATE TEMPORARY TABLE TWD (
  id INT PRIMARY KEY,
  title varchar(500) NOT NULL,
  release_date DATETIME NOT NULL,
  rating DECIMAL(3,1) NOT NULL,
  season_id INT DEFAULT NULL
);

INSERT INTO TWD
SELECT
	ep.id,
    ep.title,
    ep.release_date,
    ep.rating,
    ep.season_id
FROM episodes ep
JOIN seasons sea ON ep.season_id = sea.id
JOIN series ser ON sea.serie_id = ser.id
WHERE ser.title = "The Walking Dead";

SELECT * FROM TWD
WHERE season_id = (
	SELECT sea.id FROM seasons sea
	JOIN series ser ON sea.serie_id = ser.id
	WHERE ser.title = "The Walking Dead" AND sea.title = 'Primer Temporada'
);

-- Ejercicio 2

CREATE UNIQUE INDEX title_index ON series(title);
EXPLAIN SELECT * FROM series WHERE title = 'Breaking Bad';
SHOW INDEX FROM series;
