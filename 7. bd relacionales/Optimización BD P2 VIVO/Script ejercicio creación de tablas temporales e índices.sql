-- Ejercicio 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

CREATE TEMPORARY TABLE TWD (nombre_temporada VARCHAR(45),
                            numero_temporada INT,
                            titulo_episodio VARCHAR(45),
                            numero_episodio INT);

INSERT INTO TWD SELECT 
	    seasons.title AS nombre_temporada, 
	    seasons.number AS numero_temporada,
	    episodes.title AS titulo_episodio,
        episodes.number AS numero_episodio
FROM episodes 
LEFT JOIN seasons ON episodes.season_id = seasons.id LEFT JOIN series ON seasons.serie_id = series.id 
WHERE series.title LIKE "The Walking Dead";

SELECT * FROM TWD WHERE numero_temporada = 1;

DROP TABLE TWD;

-- Ejercicio 2
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

SELECT * FROM movies;

-- Podríamos ofrecer a los clientes recomendación de películas más vistas de un determinado género
CREATE INDEX rating_genre_idx ON movies(rating);

SHOW INDEX FROM movies;
