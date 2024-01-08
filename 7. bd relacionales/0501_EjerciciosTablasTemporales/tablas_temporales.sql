USE movies_db;

-- 1. SELECT para obtener los episodios de la serie.
SELECT 
    e.title AS "Nombre capìtulo",
	sns.title AS "Temporada",
    e.release_date AS "Fecha lanzamiento",
    e.rating AS "Calificación"
FROM 
	series s
INNER JOIN seasons sns ON sns.serie_id = s.id
INNER JOIN episodes e ON e.season_id = sns.id
WHERE 
	s.title = 'The Walking Dead';
    
-- 2. Se crea la tabla temporal
CREATE TEMPORARY TABLE TWD
	SELECT 
		e.title AS "Nombre capìtulo",
		sns.title AS "Temporada",
		e.release_date AS "Fecha lanzamiento",
		e.rating AS "Calificación"
	FROM 
		series s
	INNER JOIN seasons sns ON sns.serie_id = s.id
	INNER JOIN episodes e ON e.season_id = sns.id
	WHERE 
		s.title = 'The Walking Dead';
        
-- 3. Se consulta la tabla temporal
Select * FROM TWD;


-- Índices
SHOW INDEX FROM password_resets;
    
    