/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */
SELECT empleado.nombre, empleado.puesto, departamento.localidad
FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro;

/* Visualizar los departamentos con más de cinco empleados. */
SELECT departamento.nombre_depto, COUNT(*) AS 'total_empleados'
FROM departamento INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto
HAVING COUNT(*) > 5;

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */
SELECT empleado.nombre, empleado.puesto, empleado.salario, departamento.nombre_depto
FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (SELECT empleado.puesto FROM empleado WHERE empleado.nombre = 'Mito' AND empleado.apellido = 'Barchuk');

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */
SELECT empleado.* 
FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Contabilidad'
ORDER BY empleado.nombre;

/* Mostrar el nombre del empleado que tiene el salario más bajo. */
SELECT nombre FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado)
LIMIT 1;

/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */
SELECT empleado.* 
FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Ventas'
ORDER BY empleado.salario DESC
LIMIT 1;