-- Crear esquema
CREATE SCHEMA empresa_db;
-- Usar el esquema
USE empresa_db;

-- Crear la tabla departamento
CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

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

-- Insertar datos en la tabla departamento
INSERT INTO departamento VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

-- Insertar datos en la tabla empleado
INSERT INTO empleado VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- 1
SELECT dep.nombre_depto, emp.puesto, dep.localidad
FROM departamento dep
INNER JOIN empleado emp ON emp.depto_nro = dep.depto_nro;

-- 2
SELECT dep.depto_nro, dep.nombre_depto FROM departamento dep INNER JOIN empleado ON empleado.depto_nro = dep.depto_nro GROUP BY dep.depto_nro HAVING COUNT(dep.depto_nro) > 5;

-- 3
SELECT emp.nombre, emp.salario, dep.nombre_depto FROM empleado emp INNER JOIN departamento dep ON dep.depto_nro = emp.depto_nro WHERE emp.puesto IN (SELECT empleado.puesto FROM empleado WHERE empleado.nombre = "Mito" AND empleado.apellido = "Barchuk") ;

-- 4
SELECT * FROM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "Contabilidad" ORDER BY emp.nombre;

-- 5
SELECT nombre FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);

-- 6
SELECT nombre FROM empleado WHERE salario = (SELECT MAX(salario) FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro WHERE nombre_depto = "Ventas");
