-- EJERCICIO 1

-- 1) Crear la tabla temporal TWD y cargar los datos desde la tabla movies
CREATE TEMPORARY TABLE TWD AS
SELECT sea.number temporada, e.*
FROM series ser, seasons sea, episodes e
WHERE ser.title = "The Walking Dead" AND
	  ser.id = sea.serie_id AND
      sea.id = e.season_id;

-- 2) Ver los episodios de la primera temporada
SELECT *
FROM TWD
WHERE temporada = 1;


-- EJERCICIO 2
-- En la tabla actors podríamos crear un índice para el campo rating ya que si requerimos
-- filtrar por rating y tenemos una cantidad muy grande de registros, teniendo un índice
-- en dicho campo podríamos obtener una respuesta más rápida sin necesidad de recorrer
-- todas las filas de la tabla, haciendo más eficiente la consulta.

-- Si ejecutamos lo siguiente, vemos que las rows afectadas son 49:
EXPLAIN SELECT * FROM actors WHERE rating > 7.5; -- rows = 49

-- Con lo cual, creamos el índice
ALTER TABLE actors
ADD INDEX rating_index (rating);

-- Si volvemos a ejecutar la misma consulta anterior, vemos que las rows afectadas son 6:
EXPLAIN SELECT * FROM actors WHERE rating > 7.5; -- rows = 6