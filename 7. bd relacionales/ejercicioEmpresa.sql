INSERT INTO empleado VALUES
('E-0008', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0009', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0010', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0011', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0012', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0013', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0014', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto departamento, d.localidad localidad, count(*) cant_empleados FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING cant_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT CONCAT(e.nombre, ' ', e.apellido) empleado, e.salario salario, d.nombre_depto departamento FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*, d.nombre_depto FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'contabilidad'
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado
ORDER BY salario ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;