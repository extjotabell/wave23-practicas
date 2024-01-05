-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE movies_db.TWD(
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(500) COLLATE UTF8_UNICODE_CI DEFAULT NULL,
	`rating` DECIMAL(3,1) NOT NULL,
	`season_title` VARCHAR(500) COLLATE UTF8_UNICODE_CI DEFAULT NULL,
    PRIMARY KEY (`id`)); 

DROP TABLE movies_db.TWD;
USE movies_db; 

DELIMITER //
CREATE PROCEDURE insertarTWD()
	BEGIN
		INSERT INTO movies_db.TWD (title,rating, season_title)
SELECT episodes.title, episodes.rating, seasons.title
FROM episodes INNER JOIN
seasons 
ON episodes.season_id = seasons.id
WHERE serie_id = (SELECT id 
	From series
    WHERE series.title = "The Walking Dead");
	END //
DELIMITER ;

CALL insertarTWD();

SELECT * FROM movies_db.TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM movies_db.TWD
WHERE season_title = "Primer Temporada";

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
CREATE INDEX idx_actor_name ON actors(first_name);

SHOW INDEX FROM actors;
