select empleado.nombre, empleado.puesto, departamento.localidad
from empleado left join departamento on empleado.depto_nro = departamento.depto_nro;

select depto_nro, count(depto_nro) as cantidad_de_empleados from empleado
group by depto_nro;

select empleado.nombre,empleado.salario,departamento.nombre_depto
from empleado left join departamento on empleado.depto_nro = departamento.depto_nro
where empleado.puesto = "Presidente";

select empleado.cod_emp,empleado.nombre,empleado.apellido,empleado.puesto,
empleado.fecha_alta,empleado.salario,empleado.comision,empleado.depto_nro
from empleado left join departamento on empleado.depto_nro = departamento.depto_nro
where departamento.nombre_depto = "contabilidad"
order by empleado.nombre asc;

SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT *
FROM empleado
WHERE salario = (SELECT MAX(salario) FROM empleado);


