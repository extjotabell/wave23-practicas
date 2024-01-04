-- EJERCICIO 2

-- a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- DNI, ya que es un identificador único.

-- b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
-- Creamos plan_id, ya que debemos identificar unequívocamente a cada plan.alter

-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
-- Entendemos que, 1 cliente puede contratar varios planes, así como 1 plan puede ser contratado a su vez por n clietes
-- por ende, creamos una tabla intermedia (contract) que contiene a ambos, sumando adicionalmente el campo con la fecha
-- de contratación.



-- EJERCICIO 3

-- Se solicita crear una nueva base de datos llamada “empresa_internet”. 
CREATE SCHEMA empresa_internet;

USE empresa_internet;

CREATE TABLE cliente(
	dni INT NOT NULL PRIMARY KEY,
    nombre VARCHAR (50) NOT NULL,
    apellido VARCHAR (50) NOT NULL,
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);

CREATE TABLE plan(
	id INT NOT NULL PRIMARY KEY,
    velocidad INT NOT NULL,
    descuento INT,
    precio DECIMAL (10,2)
);

CREATE TABLE contrato(
	id INT NOT NULL PRIMARY KEY,
    plan_id INT NOT NULL ,
    cliente_dni INT,
    fecha_contratacion DATE,
    FOREIGN KEY (cliente_dni) REFERENCES cliente(dni),
    FOREIGN KEY (plan_id) REFERENCES plan(id)
);


-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO cliente VALUES (11234564, "Juan", "Perez", "2000-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (56475937, "Pedro", "Lezcano", "1990-01-30", "CABA", "San Cristóbal");
INSERT INTO cliente VALUES (45341675, "María", "González", "1998-06-12", "Buenos Aires", "Morón");
INSERT INTO cliente VALUES (54678553, "Pablo", "García", "1980-04-12", "Chubut", "Ciudad de Chubut");
INSERT INTO cliente VALUES (78654324, "Gabriel", "Perez", "2000-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (56396744, "Adrian", "Tomasini", "1970-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (45123450, "Gustavo", "Cardozo", "1980-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (90876549, "Sofía", "Carballo", "1998-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (70385869, "Tamara", "Gómez", "1999-01-12", "Buenos Aires", "San justo");
INSERT INTO cliente VALUES (65832020, "Ayelen", "Doldán", "2000-01-12", "Buenos Aires", "San justo");

INSERT INTO plan VALUES (1, 300, 10, 5000.00);
INSERT INTO plan VALUES (2, 500, null, 8000.0);
INSERT INTO plan VALUES (3, 100, 10, 4000.0);
INSERT INTO plan VALUES (4, 1000, 10, 15000.0);
INSERT INTO plan VALUES (5, 200, 10, 54500.0);

-- Realizar las asociaciones/relaciones correspondientes entre estos registros.
INSERT INTO contrato VALUES (1,1, 56396744, "2023-05-01");
INSERT INTO contrato VALUES (2,2, 70385869, "2021-05-30");
INSERT INTO contrato VALUES (3,5, 78654324, "2020-05-17");
INSERT INTO contrato VALUES (4,1, 54678553, "2023-05-20");
INSERT INTO contrato VALUES (5,2, 56475937, "2022-05-01");


-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

--  1. Listado de planes con descuento 
SELECT velocidad, precio FROM plan WHERE descuento IS NOT NULL;

--  2. Listado de clientes de CABA
SELECT nombre, apellido FROM cliente WHERE provincia LIKE '%CABA%';

-- 3. Listado de clientes con un plan
SELECT cli.nombre, cli.apellido, p.velocidad FROM cliente cli 
INNER JOIN contrato con ON cli.dni = con.cliente_dni 
INNER JOIN plan p ON p.id = con.plan_id
WHERE con.plan_id IS NOT NULL;

-- 4. Listado de clientes con plan activo desde 2021-05-30
SELECT cli.nombre, cli.apellido FROM cliente cli 
INNER JOIN contrato con ON cli.dni = con.cliente_dni 
WHERE con.fecha_contratacion > "2021-05-30";

-- 5. Listado de clientes con plan con descuento contratado desde 2021-05-30
SELECT cli.nombre, cli.apellido, p.descuento FROM cliente cli 
INNER JOIN contrato con ON cli.dni = con.cliente_dni 
INNER JOIN plan p ON p.id = con.plan_id
WHERE con.fecha_contratacion > "2021-05-30" AND p.descuento IS NOT NULL;

-- 6. Listado ordenado de clientes por fecha de contatación de plan
SELECT cli.nombre, cli.apellido, con.fecha_contratacion FROM cliente cli 
INNER JOIN contrato con ON cli.dni = con.cliente_dni 
WHERE con.plan_id IS NOT NULL
ORDER BY con.fecha_contratacion DESC;

-- 7. Listado de planes mayores a 100 mb
SELECT velocidad, precio FROM plan
WHERE velocidad > 100
ORDER BY velocidad;

-- 8. Listado de clientes menores de 30 años
SELECT nombre, apellido, YEAR(CURDATE()) - YEAR(fecha_nacimiento) AS edad 
FROM cliente 
WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) < 30;

-- 9. Listado de clientes de 30 años o mas
SELECT nombre, apellido, YEAR(CURDATE()) - YEAR(fecha_nacimiento) AS edad 
FROM cliente 
WHERE YEAR(CURDATE()) - YEAR(fecha_nacimiento) >= 30;

-- 10. Plan con mayor precio
SELECT velocidad, precio 
FROM plan 
ORDER BY precio DESC
LIMIT 1;

-- 11. Plan con menor precio
SELECT velocidad, precio 
FROM plan 
ORDER BY precio ASC
LIMIT 1;
