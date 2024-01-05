-- Crear el esquema
CREATE SCHEMA mi_empresa;

-- Usar el esquema
USE mi_empresa;

-- Crear la tabla departamento
CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Insertar datos en la tabla departamento
INSERT INTO departamento VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Crear la tabla empleado
CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

-- Insertar datos en la tabla empleado
INSERT INTO empleado VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Consultas

-- 1 - Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre,puesto,localidad
FROM empleado
INNER JOIN departamento ON departamento.depto_nro = empleado.depto_nro;

-- 2 - Visualizar los departamentos con más de cinco empleados.
SELECT COUNT(empleado.cod_emp) AS cantidad_empleados, departamento.nombre_depto
FROM departamento
INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto
HAVING cantidad_empleados > 5;

-- 3 - Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto
FROM departamento
INNER JOIN empleado ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (
	SELECT puesto FROM empleado
    WHERE nombre LIKE 'Mito' AND 
    apellido LIKE 'Barchuk'
);

-- 4 - Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.* FROM departamento
INNER JOIN empleado ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto LIKE 'Contabilidad'
ORDER BY empleado.nombre;

-- 5 - Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido, salario FROM empleado
ORDER BY salario LIMIT 1;

-- 6 - Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre, apellido, salario FROM empleado
WHERE salario = (
	SELECT MAX(salario) FROM departamento
    INNER JOIN empleado ON empleado.depto_nro = departamento.depto_nro
    WHERE departamento.nombre_depto LIKE 'Ventas'
);

