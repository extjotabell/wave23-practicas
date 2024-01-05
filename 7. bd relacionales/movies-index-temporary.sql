USE movies_db;

--      EJERCICIO 1:

-- 1. Tabla temporal TWD: 

CREATE TEMPORARY TABLE TWD (SELECT episodes.*, seasons.number AS season_number FROM episodes 
						   INNER JOIN seasons ON episodes.season_id = seasons.id
						   INNER JOIN series ON seasons.serie_id = series.id
                           WHERE series.title = 'The Walking Dead');
                           
 -- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
 
SELECT *
FROM TWD
WHERE season_number = 1;

--      EJERCICIO 2:

-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- Se crea un indice sobre rating en movies.
 
CREATE INDEX movies_rating  ON movies (rating);
SHOW INDEX FROM movies_db.movies;

-- 2. Analisis: Se crea un campo sobre este campo ya que es común consultar peliculas segun su rating.