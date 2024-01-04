CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE planes_internet (
	plan_internet_id integer primary key AUTO_INCREMENT,
    nombre_plan varchar(20) unique not null,
    velocidad_en_megas DECIMAL(5, 2) unique not null,
    precio DECIMAL(7, 2) unique not null,
	descuento DECIMAL(5, 2) not null
);


CREATE TABLE clientes (
	cliente_id integer primary key AUTO_INCREMENT,
    dni char(9) not null unique,
    nombre varchar(60) not null,
    fecha_de_nacimiento datetime not null,
    provincia varchar(50) not null,
    ciudad varchar(30) not null,
    plan_internet_id integer not null,
    constraint fk_clientes_planes_internet
    foreign key plan_internet_id (plan_internet_id)
    references planes_internet (plan_internet_id)
    on delete cascade
    on update cascade
);

INSERT INTO planes_internet VALUES (1, "Plan menor", 1, 300, 1.0);
INSERT INTO planes_internet VALUES (2, "Plan básico", 10, 600, 4.0);
INSERT INTO planes_internet VALUES (3, "Plan medio", 50, 3000, 10.0);
INSERT INTO planes_internet VALUES (4, "Plan avanzado", 100, 5000, 15.7);
INSERT INTO planes_internet VALUES (5, "Plan empresarial", 999, 40000, 33.3);

INSERT INTO clientes (`cliente_id`,`dni`,`nombre`,`fecha_de_nacimiento`,`provincia`,`ciudad`,`plan_internet_id`)
VALUES
  (1,"GU7805563","Zephr Rodriguez","2023-01-16 12:12:57","Amazonas","Samaniego",4),
  (2,"HU5807677","Tad Cruz","2024-11-10 16:38:11","Maule","Ilhéus",4),
  (3,"CP3648393","Giacomo Lopez","2024-04-19 01:23:43","Guanacaste","Juazeiro do Norte",4),
  (4,"GC1716653","Josiah Velasco","2023-10-26 21:54:59","Cajamarca","Rio Grande",2),
  (5,"LG2788322","Amela Ramirez","2024-02-20 20:45:27","Maule","Tapachula",4),
  (6,"BW7280583","Melyssa Pascual","2023-06-30 00:55:33","Pará","Ciudad Madero",3),
  (7,"GV4851317","Thomas Rodriguez","2023-12-30 15:34:20","O'Higgins","Tehuacán",5),
  (8,"JH1350836","Drake Marti","2024-07-25 09:36:40","Putumayo","Valdivia",3),
  (9,"WK5127624","Lillith Jimenez","2023-03-01 01:23:34","Lima","El Retorno",3),
  (10,"BU5125626","Amity Nuñez","2023-02-21 01:11:48","Sinaloa","Itabuna",1);

-- 1. Mostrar todos los planes
SELECT * FROM planes_internet;
-- 2. Mostrat todos los clientes
SELECT * FROM clientes;
-- 3. Mostrar clientes que hayan registrado Tapachula como Ciudad
SELECT * FROM clientes WHERE ciudad = 'Tapachula';
-- 4. Mostrar los planes por orden alfabetico
SELECT * FROM planes_internet ORDER BY nombre_plan;
-- 5. Mostrar el nombre de los planes que tengan 19 o más de descuento
SELECT nombre_plan FROM planes_internet WHERE descuento >= 10;
-- 6. Mostrar el nombre de los clientes que tengan una z en su nombre
-- Nota: Por defecto MySQL es case insentive (esto se puede configurar en la tabla o en la base)
SELECT nombre FROM clientes WHERE nombre LIKE '%z%';
-- 7. Mostrar los planes que cuestan más de 600
SELECT * FROM planes_internet WHERE precio > 600;
-- 8. Mostrar los nombres de los clientes que tienen el plan medio (sin join)
SELECT nombre FROM clientes WHERE plan_internet_id = 3;
-- 9. Calcular el promedio del precio de los planes
SELECT AVG(precio) AS promedio_precio_planes FROM planes_internet;
-- 10. Obtener 2 planes que tienen un descuento menor o igual a 20
-- ordenados por precio de manera descendente
SELECT * FROM planes_internet WHERE descuento <= 20 ORDER BY precio DESC LIMIT 2;