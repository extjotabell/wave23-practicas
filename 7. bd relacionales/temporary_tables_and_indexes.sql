create index idx_series_title on series (title);

show index from series;

create temporary table TWD as 
select episodes.* from episodes 
join seasons on episodes.season_id = seasons.id
join series on seasons.serie_id = series.id
where series.title = 'The Walking Dead';

select TWD.* from TWD
join seasons on TWD.season_id = seasons.id
where seasons.number = 1;