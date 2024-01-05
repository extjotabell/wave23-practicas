/*
Ejercicios

Ejercicio 2
a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
	En nuestro caso elegimos el DNI ya que es identificador único de persona. Pero también se podría crear una alternativa de ID. Y tener el DNI como restricción única.

b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
	En nuestro caso elegimos “identificación del plan” ya que este podría identificar unívocamente a uno mismo.

c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
	Las relaciones entre tablas, decidimos hacerla de N(plan)-N(cliente).  	Generamos una tabla intermedia “Contratación” claves foráneas de plan y cliente con datos de relación. 
*/

-- PARTE DDL

DROP DATABASE empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;


CREATE TABLE province(
	id tinyint primary key,
    description varchar(50)
);

CREATE TABLE city(
	id tinyint primary key,
    description varchar(50)
);

CREATE TABLE client(
	dni int primary key,
    first_name varchar(15),
    last_name varchar(15),
    birth_date datetime,
    province_id tinyint,
    city_id tinyint,
	foreign key (province_id) references province(id),
    foreign key (city_id) references city(id)
);

CREATE TABLE plan(
	id int primary key,
    speed_mb int,
    price double,
    discount int
);

CREATE TABLE contratation(
	id int primary key,
    plan_id int,
    client_dni int,
    date_start datetime,
    date_end datetime,
    foreign key (plan_id) references plan(id),
    foreign key (client_dni) references client(dni)
);

-- PARTE DML

INSERT INTO city(id, description) 
VALUES (1, "Montevideo");

INSERT INTO province(id, description)
VALUES (1, "Buenos Aires");

INSERT INTO client(dni, first_name, last_name, birth_date, province_id, city_id)
VALUES 
(11111111, "Pepe", "Gonzalez", "2000-03-13", 1, 1),
(22222222, "Maria", "Gonzalez", "2001-03-13", 1, 1),
(33333333, "Juan", "Gonzalez", "2002-03-13", 1, 1),
(44444444, "Rosana", "Gonzalez", "2003-03-13", 1, 1),
(55555555, "Felipe", "Gonzalez", "2000-03-13", 1, 1),
(66666666, "Jose", "Gonzalez", "2001-03-13", 1, 1),
(77777777, "Pez", "Gonzalez", "2002-03-13", 1, 1),
(88888888, "Sofia", "Gonzalez", "2003-03-13", 1, 1),
(99999999, "Lautaro", "Gonzalez", "2002-03-13", 1, 1),
(10101010, "Josefa", "Gonzalez", "2003-03-13", 1, 1);


INSERT INTO plan(id, speed_mb, price, discount)
VALUES 
(1, 60, 8000, 50000),
(2, 100, 11000, 50000),
(3, 300, 150000, 50000),
(4, 500, 24000, 50000),
(5, 1000, 45000, 50000);


INSERT INTO contratation(id, plan_id, client_dni, date_start, date_end)
VALUES 
(1, 1, 11111111, "2000-10-10", "2002-10-10"),
(2, 2, 22222222, "2001-10-10", "2003-10-10"),
(3, 3, 33333333, "2003-10-10", "2005-10-10"),
(4, 4, 88888888, "2003-10-10", "2005-10-10"),
(5, 5, 10101010, "2000-10-10", "2005-10-10");

-- PARTE DML CONSULTAS

-- Todos los clientes
SELECT * 
FROM client;

-- Todos los planes
SELECT * 
FROM plan;

-- Todas las contrataciones
SELECT *
FROM contratation;

-- Los nombres de los clientes que nacieron en 2003
SELECT first_name as "Nombre"
FROM client
WHERE birth_date BETWEEN "2003-01-01" AND "2003-12-31";

-- Los nombres planes que el precio superen 13000
SELECT *
FROM plan
WHERE price > 13000;


