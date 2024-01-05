-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad 
from empleado e natural join departamento d
where e.puesto like "vendedor";
-- Visualizar los departamentos con más de cinco empleados.
select count(*) total, d.nombre_depto
from empleado e natural join departamento d
group by d.depto_nro
having total > 5;
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select * from empleado;
select nombre, apellido, salario, depto_nro
from empleado
where puesto = 
(select puesto from empleado where nombre like "Mito" and apellido like "Barchuk");
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from departamento;
select *
from empleado
where depto_nro in (select depto_nro from departamento where nombre_depto like "Contabilidad")
order by nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre 
from empleado
where salario = (select min(salario) from empleado);
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select *
from empleado
where depto_nro in (select depto_nro from departamento where nombre_depto like "Ventas")
order by salario desc
limit 1;