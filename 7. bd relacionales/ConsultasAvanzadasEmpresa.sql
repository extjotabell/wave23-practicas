show tables;

select * from departamento;

select * from empleado;

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre, empleado.puesto, departamento.localidad FROM 
	empleado NATURAL JOIN departamento
    WHERE empleado.puesto = "vendedor";
-- Visualizar los departamentos con más de cinco empleados.
SELECT count(*) AS total_empleados, departamento.* FROM 
	empleado NATURAL JOIN departamento
    GROUP BY departamento.depto_nro
    HAVING count(*) > 5;
-- Mostrar el nombre, salario y nombre del departamento de los empleados que 
-- tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto FROM 
	empleado NATURAL JOIN departamento
    WHERE empleado.puesto = (
		SELECT puesto FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk"
    );
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.* FROM 
	empleado NATURAL JOIN departamento
    WHERE departamento.nombre_depto = "Contabilidad"
    ORDER BY empleado.nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT empleado.nombre FROM empleado
    WHERE empleado.salario = (SELECT min(salario) FROM empleado
    );
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT empleado.* FROM
	empleado NATURAL JOIN departamento
    WHERE departamento.nombre_depto = "Ventas"
    ORDER BY salario DESC LIMIT 1;