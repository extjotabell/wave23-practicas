select * from clientes;

select * from planes_internet;

select * from hogares;

select * from contratos;

select hogares.ciudad, fecha_contrato from contratos 
join hogares on contratos.id_hogar = hogares.id;

select hogares.ciudad, clientes.nombre from contratos 
join hogares on contratos.id_hogar = hogares.id
join clientes on hogares.dni_cliente = clientes.dni;

select velocidad_megas from planes_internet
where precio > 80000;

select nombre from clientes
where year(fecha_nacimiento) between 2000 and 2002;

select nombre from clientes
where nombre like "S%";

select direccion from hogares
join clientes on hogares.dni_cliente = clientes.dni
where clientes.nombre = 'Miguel' and clientes.apellido = 'Ochoa'; 

select clientes.direccion, contratos.fecha_contrato, planes_internet.precio from hogares
join clientes on hogares.dni_cliente = clientes.dni
join contratos on hogares.id = contratos.id_hogar
join planes_internet on contratos.id_plan_internet = planes_internet.id;
