-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT CONCAT(e.nombre, ' ', e.apellido) nombre, e.puesto, d.localidad
FROM Departamento d INNER JOIN Empleado e
ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.*, COUNT(*) empleados
FROM Departamento d INNER JOIN Empleado e
ON e.depto_nro = d.depto_nro
GROUP BY e.depto_nro;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT CONCAT(e.nombre, ' ', e.apellido) nombre, e.salario, d.nombre_depto
FROM Empleado e INNER JOIN Departamento d
ON e.depto_nro = d.depto_nro
WHERE E.puesto = (
	SELECT puesto
    FROM Empleado
    WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM Empleado e LEFT JOIN Departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad';

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT CONCAT(e.nombre, ' ', e.apellido) nombre
FROM Empleado e
ORDER BY salario ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM Empleado e LEFT JOIN Departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;
