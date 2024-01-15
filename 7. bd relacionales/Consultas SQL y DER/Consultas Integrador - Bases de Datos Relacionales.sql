/*Planes con costo menor a 30000*/
SELECT * FROM planes_internet WHERE precio_plan_internet < 30000;
/*Planes con descuento*/
SELECT * FROM planes_internet WHERE descuento_plan_internet > 0;
/*Plan con mayor velocidad y su velocidad*/
SELECT identificacion_plan_internet, velocidad_en_mb_plan_internet FROM planes_internet order by velocidad_en_mb_plan_internet desc limit 1;
/*Todos los planes ordenados por precio descendente*/
SELECT * FROM planes_internet ORDER BY precio_plan_internet DESC;
/*Plan con menor precio y su velocidad*/
SELECT identificacion_plan_internet, velocidad_en_mb_plan_internet FROM planes_internet order by precio_plan_internet asc limit 1;

/*Top 5 clientes más jóvenes*/
SELECT * from clientes order by fecha_nacimiento_cliente desc limit 5;
/*Clientes por provincia*/
Select provincia_cliente, count(provincia_cliente) as cantidad_clientes from clientes group by provincia_cliente;
/*Clientes por plan ordenado de mayor a menor*/
Select identificacion_plan_internet as plan, count(identificacion_plan_internet) as cantidad_clientes from clientes group by identificacion_plan_internet order by cantidad_clientes desc;
/*Clientes de Cordoba*/
SELECT * from clientes where provincia_cliente = 'CORDOBA';
/*Ciudad con mayor cantidad de clientes*/
Select ciudad_cliente, count(ciudad_cliente) as cantidad_clientes from clientes group by ciudad_cliente order by cantidad_clientes desc limit 1;