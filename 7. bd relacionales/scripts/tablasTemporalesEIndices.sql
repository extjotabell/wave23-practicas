-- Ejercicio 1
-- Creacion de la tabla
create temporary table episodios_the_walking_dead select episodes.title from episodes where episodes.season_id in
(select seasons.id from seasons where seasons.serie_id in
(SELECT series.id from series where series.title = "The Walking Dead"));
-- Seleccion de los registros
select * from episodios_the_walking_dead;

-- Ejercicio 2
-- Creacion del indice
create index idx_title_episode on episodes(title);
-- Mostrar indice
show index from episodes;

-- Crearia un indice en un campo siempre y cuando se frecuente el acceso mediante este y el volumen de datos sea muy grande.
-- Tambien teniendo en cuenta que no se debe elegir un campo que sea propenso a ser modificado, o una tabla en la cual no se realicen muchas inserciones
