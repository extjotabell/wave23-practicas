-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad
FROM empleado inner join 
departamento 
ON empleado.depto_nro = departamento.depto_nro;

-- Visualizar los departamentos con más de tres empleados.
SELECT departamento.* , count(*) empleado
FROM empleado inner join 
departamento 
ON empleado.depto_nro = departamento.depto_nro
group by empleado.depto_nro
having empleado > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select concat(nombre ,' ', apellido) as nombre, puesto, salario, nombre_depto
FROM empleado inner join 
departamento 
ON empleado.depto_nro = departamento.depto_nro
WHERE puesto like (SELECT puesto 
	from empleado
    where concat(nombre ,' ', apellido) like "Mito Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
