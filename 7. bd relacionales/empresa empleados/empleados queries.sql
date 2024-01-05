use empresa_db;
#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select nombre, puesto, localidad
from empleado
inner join departamento
on departamento.depto_nro = empleado.depto_nro;

#Visualizar los departamentos con más de cinco empleados.
select nombre_depto, count(*) as cant_empleados
from empleado
inner join departamento
on empleado.depto_nro = departamento.depto_nro
group by departamento.depto_nro
having cant_empleados >5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select nombre, salario, nombre_depto
from empleado
inner join departamento
on departamento.depto_nro = empleado.depto_nro
where puesto = (select puesto from empleado where nombre='Mito' and apellido='Barchuk');

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select nombre
from empleado
inner join departamento
on departamento.depto_nro = empleado.depto_nro
where departamento.nombre_depto = 'contabilidad'
order by nombre desc;

#Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleado
order by salario asc
limit 1;

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select nombre
from empleado
inner join departamento
on departamento.depto_nro = empleado.depto_nro
where departamento.nombre_depto = 'ventas'
order by salario desc
limit 1;

