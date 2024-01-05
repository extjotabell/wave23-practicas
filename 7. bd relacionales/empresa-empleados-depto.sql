

DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;

-- CREACION TABLAS:

CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(12, 2),
    comision DECIMAL(12, 2),
    depto_nro VARCHAR(10),
    PRIMARY KEY (cod_emp),
    KEY `empleado_depto_nro_foreign` (`depto_nro`),
    CONSTRAINT `empleado_depto_nro_foreign` FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO (depto_nro)
);




-- INSERT:
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES ('D-000-1', 'Software', 'Los Tigres');

INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES ('D-000-2', 'Sistemas', 'Guadalupe');

INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES ('D-000-3', 'Contabilidad', 'La Roca');

INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES ('D-000-4', 'Ventas', 'Plata');



INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');

INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- CONSULTAS:

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT nombre, puesto, departamento.localidad
FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE puesto = "Vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.

SELECT depto_nro, nombre_depto
FROM (SELECT d.depto_nro, d.nombre_depto, COUNT(e.cod_emp) as total_empleados
FROM DEPARTAMENTO d
INNER JOIN EMPLEADO e ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro, d.nombre_depto
HAVING total_empleados > 5 ) AS empleados_numero_subconsulta; 

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT nombre, salario, departamento.nombre_depto
FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE puesto = (SELECT puesto 
				FROM empleado
				INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
                WHERE nombre = 'Mito' AND apellido = 'Barchuk') AND nombre != 'Mito' AND apellido != 'Barchuk';

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT nombre, apellido, puesto, salario 
FROM empleado
WHERE depto_nro = (SELECT depto_nro 
				   FROM departamento 
				   WHERE nombre_depto = 'Contabilidad')
ORDER BY nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT  nombre, apellido, puesto, salario 
FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Ventas'
ORDER BY salario DESC
LIMIT 1;