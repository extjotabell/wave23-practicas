/* 1- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */

select nombre, puesto, localidad
from empleado
inner join departamento on departamento.depto_nro = empleado.depto_nro
where puesto = "vendedor";

/*2- Visualizar los departamentos con más de cinco empleados.*/

SELECT *
FROM departamento d
INNER JOIN (
    SELECT depto_nro, COUNT(*) as total_empleados
    FROM empleado
    GROUP BY depto_nro
    HAVING COUNT(*) > 5
) e_count ON d.depto_nro = e_count.depto_nro;

/* 3- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/

select e.nombre, e.apellido, e.salario, d.nombre_depto 
from empleado e 
join departamento d on e.depto_nro=d.depto_nro 
where e.puesto = (SELECT puesto from empleado where nombre = "Mito" and apellido = "Barchuk");

/* 4- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/

/*select * from empleado
where empleado.depto_nro = (select depto_nro from departamento where nombre_depto = "contabilidad")
order by empleado.nombre*/

select e.*, d.nombre_depto
from empleado e
inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'contabilidad'
order by e.nombre;

/* 5- Mostrar el nombre del empleado que tiene el salario más bajo. */

select nombre
from empleado
where salario = (select min(salario) from empleado)
limit 1;

/* 6- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */

/*select *
from empleado
where depto_nro = (select depto_nro from departamento where nombre_depto = 'Ventas') and 
      salario = (select max(salario) from empleado)
limit 1;*/

select * 
from mi_empresa.empleado
join mi_empresa.departamento on mi_empresa.departamento.depto_nro = mi_empresa.empleado.depto_nro
where mi_empresa.departamento.nombre_depto = "ventas"
order by mi_empresa.empleado.salario desc
limit 1;