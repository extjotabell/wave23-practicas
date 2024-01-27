
/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
Select e.nombre, e.puesto, d.localidad 
from empleado e 
join departamento d on e.depto_nro=d.depto_nro;

/*Visualizar los departamentos con más de cinco empleados.*/
Select depto_nro, count(depto_nro) as cantidad_empleados 
from empleado 
where cantidad_empleados >5 
group by depto_nro;

/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/

Select e.nombre, e.apellido, e.salario, d.nombre_depto 
from empleado e 
join departamento d on e.depto_nro=d.depto_nro 
where e.puesto = 
	(SELECT puesto 
	from empleado 
    where nombre = "Mito" 
    and apellido = "Barchuk");

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/

Select * from empleado 
where depto_nro = 
	(select depto_nro 
    from departamento 
    where nombre_depto = "Contabilidad");

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
Select nombre, apellido 
from empleado 
where salario = 
	(select min(salario) 
    from empleado);

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT e.nombre, e.apellido 
FROM empleado e 
JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas' 
ORDER BY e.salario DESC 
LIMIT 1;