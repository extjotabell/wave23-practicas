select e.nombre, e.puesto, d.localidad from empleado e
join departamento d on e.depto_nro = d.depto_nro
where e.puesto = 'Vendedor';

select d.depto_nro, d.nombre_depto, count(e.cod_emp) as num_empleados
from departamento d
join empleado e on d.depto_nro = e.depto_nro
group by d.depto_nro
having count(e.cod_emp) > 5;

select e.nombre, e.salario, d.nombre_depto from empleado e
join departamento d on e.depto_nro = d.depto_nro
where e.puesto = (select puesto from empleado where apellido = 'Barchuk' and nombre like 'Mito%');

select e.* from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Contabilidad'
order by e.nombre;

select nombre from empleado
where salario = (select min(salario) from empleado);

select e.* from empleado e
join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Ventas' 
and e.salario = (select max(salario) from empleado e2 join departamento d2 on e2.depto_nro = d2.depto_nro where d2.nombre_depto = 'Ventas');