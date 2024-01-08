-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleados.nombre, empleados.puesto, departamentos.localidad 
FROM empleados LEFT JOIN departamentos ON empleados.depto_nro = departamentos.depto_nro
WHERE empleados.puesto = "Vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT departamentos.nombre_depto 
FROM empleados LEFT JOIN departamentos ON empleados.depto_nro = departamentos.depto_nro
GROUP BY empleados.depto_nro HAVING COUNT(*) > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SET @puesto = (SELECT puesto FROM empleados WHERE nombre LIKE "Mito" AND apellido LIKE "Barchuk");

SELECT empleados.nombre, empleados.salario, departamentos.nombre_depto
FROM empleados LEFT JOIN departamentos ON empleados.depto_nro = departamentos.depto_nro
WHERE empleados.puesto = @puesto;

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleados.*
FROM empleados LEFT JOIN departamentos ON empleados.depto_nro = departamentos.depto_nro
WHERE departamentos.nombre_depto = "Contabilidad";

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleados ORDER BY salario ASC LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SET @salarioMaximoVtas = (SELECT MAX(empleados.salario) FROM empleados WHERE depto_nro = "D-000-4");

SELECT empleados.* 
FROM empleados LEFT JOIN departamentos ON empleados.depto_nro = departamentos.depto_nro
WHERE departamentos.nombre_depto = "Ventas" AND empleados.salario = @salarioMaximoVtas;



