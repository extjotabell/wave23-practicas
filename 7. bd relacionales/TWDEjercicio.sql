
create temporary table TWD as
select episodes.* from episodes 
JOIN seasons ON seasons.id = episodes.season_id
JOIN series ON series.id = seasons.serie_id
WHERE series.title = "The Walking Dead";

select TWD.* from TWD
JOIN seasons ON seasons.id = TWD.season_id
where seasons.title LIKE "Primer Temporada";

create index idx_genres_name on genres(name);

-- Se creo el indice en la columna name de genero para poder buscar mas rapido en una consulta 
-- que requiera saber de que genero es la pelicula