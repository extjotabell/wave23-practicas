-- 1) Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT d.nombre_depto, e.puesto, d.localidad
FROM empleados e, departamentos d
WHERE e.depto_nro = d.depto_nro;

-- 2) Visualizar los departamentos con más de cinco empleados
SELECT d.nombre_depto, count(*) empleados
FROM departamentos d, empleados e
WHERE d.depto_nro = e.depto_nro
GROUP BY nombre_depto
HAVING count(*) > 5;

-- 3) Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados e, departamentos d
WHERE e.depto_nro = d.depto_nro AND
	  e.puesto = (SELECT puesto FROM empleados WHERE nombre = "Mito" and apellido = "Barchuk") AND
      e.nombre != "Mito" AND
      e.apellido != "Barchuk";

-- 4) Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre
SELECT e.*
FROM empleados e, departamentos d
WHERE e.depto_nro = d.depto_nro AND
	  d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

-- 5) Mostrar el nombre del empleado que tiene el salario más bajo
SELECT nombre
FROM empleados
WHERE salario = (SELECT MIN(salario) FROM empleados);

-- 6) Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
SELECT e.*
FROM empleados e, departamentos d
WHERE e.depto_nro = d.depto_nro AND
	  d.nombre_depto = "Ventas"
ORDER BY e.salario desc LIMIT 1;