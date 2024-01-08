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

INSERT INTO city(id, description) 
VALUES (1, "Montevideo");

INSERT INTO province(id, description)
VALUES (1, "Buenos Aires");

INSERT INTO client(dni, first_name, last_name, birth_date, province_id, city_id)
VALUES (343412323, "Pepe", "Gonzalez", "2000-03-13", 1, 1);

INSERT INTO plan(id, speed_mb, price, discount)
VALUES (1, 300, 150000, 50000);

INSERT INTO contratation(id, plan_id, client_dni, date_start, date_end)
VALUES (1, 1, 1, "2000-10-10", "2002-10-10")