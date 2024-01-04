create database empresa_internet;
use empresa_internet;

create table clientes (
	dni varchar(10) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    fecha_nacimiento date not null,
    
    primary key (dni)
);

create table hogares (
	id int unsigned auto_increment not null,
    dni_cliente varchar(10) not null,
    provincia varchar(50) not null,
    ciudad varchar(50) not null,
    direccion varchar(50) not null,
    
    primary key (id),
    
    key hogares_dni_cliente_foreign (dni_cliente),
    constraint hogares_dni_cliente_foreign foreign key (dni_cliente) references clientes (dni)
);

create table planes_internet (
	id int unsigned auto_increment not null,
    velocidad_megas int not null,
    precio decimal not null,
    descuento decimal,
    
    primary key (id)
);

create table contratos (
	id int unsigned auto_increment not null,
    id_hogar int unsigned not null,
    id_plan_internet int unsigned not null,
    fecha_contrato date not null,
    
    primary key (id),
    
    key contratos_id_hogar_foreign (id_hogar),
    constraint contratos_id_hogar_foreign foreign key (id_hogar) references hogares (id),
    
    key contratos_id_plan_internet_foreign (id_plan_internet),
    constraint contratos_id_plan_internet_foreign foreign key (id_plan_internet) references planes_internet (id)
);

insert into clientes
values ('10', 'Miguel', 'Ochoa', '2001-05-11');

insert into clientes
values ('11', 'Samuel', 'Ospina', '2001-04-12');

insert into clientes
values ('12', 'Fernando', 'Gomez', '2001-06-10');

insert into clientes
values ('13', 'Isabel', 'Mejia', '2001-03-13');

insert into clientes
values ('14', 'Sofia', 'Rojas', '2001-07-09');

insert into clientes
values ('15', 'Miguel', 'Ramirez', '2001-02-14');

insert into clientes
values ('16', 'Elena', 'Restrepo', '2001-08-08');

insert into clientes
values ('17', 'Juana', 'Garcia', '2000-01-15');

insert into clientes
values ('18', 'Simon', 'Pelaez', '1999-12-16');

insert into clientes
values ('19', 'Andres', 'Osorio', '2003-09-19');

insert into planes_internet (velocidad_megas, precio, descuento)
values (80, 60800, null);

insert into planes_internet (velocidad_megas, precio, descuento)
values (100, 80800, null);

insert into planes_internet (velocidad_megas, precio, descuento)
values (120, 100800, null);

insert into planes_internet (velocidad_megas, precio, descuento)
values (140, 120800, null);

insert into planes_internet (velocidad_megas, precio, descuento)
values (160, 140800, null);

insert into hogares (dni_cliente, provincia, ciudad, direccion)
values ('10', 'Antioquia', 'Medellin', 'Street 1');

insert into hogares (dni_cliente, provincia, ciudad, direccion)
values ('10', 'Antioquia', 'Envigado', 'Street 2');

insert into hogares (dni_cliente, provincia, ciudad, direccion)
values ('11', 'Cundinamarca', 'Bogota', 'Street 3');

insert into contratos (id_hogar, id_plan_internet, fecha_contrato)
values (1, 2, '2024-01-04');

insert into contratos (id_hogar, id_plan_internet, fecha_contrato)
values (3, 4, '2024-01-04');

insert into contratos (id_hogar, id_plan_internet, fecha_contrato)
values (2, 3, '2024-01-04');
