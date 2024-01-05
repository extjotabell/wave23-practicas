-- Practica normalización
CREATE DATABASE test_tables;
USE test_tables;
CREATE TABLE clientes_facturas_productos (
	id_factura int(11),
    fecha_factura date,
    -- Parece que el tipo de dato no es adecuado
    forma_pago decimal(10, 0),
    IVA decimal(10,0),
    cantidad int(11),
    importe decimal(10,0),
    nombre_cliente varchar(40),
    apellido_cliente varchar(40),
    descripción_artículo varchar(40)
);

-- Antes de comenzar con la normalización seria bueno mejorar los tipos de datos de la tabla
CREATE TABLE clientes_facturas_productos_2 (
	id_factura int primary key,
    fecha_factura date not null,
    forma_pago varchar(20) not null,
    IVA decimal(10,0) not null,
    cantidad int not null,
    importe decimal(10,0) not null,
    nombre_cliente varchar(40) not null,
    apellido_cliente varchar(40) not null,
    descripción_artículo varchar(40) not null
);

-- No esta en primera forma normal porque los datos de los clientes tienen que estar en su
-- respectiva tabla (formarían grupos repetidos si no se hace de esta forma) lo mismo
-- sucedería con los productos

CREATE TABLE facturas_primeraformanormal (
	id_factura int primary key,
    fecha_factura date not null,
    forma_pago varchar(20) not null,
    importe decimal(10,0) not null
);

CREATE TABLE clientes_primeraformanormal (
	id_factura int not null,
    nombre_cliente varchar(40) not null,
    apellido_cliente varchar(40) not null,
	FOREIGN KEY (id_factura) REFERENCES facturas_primeraformanormal(id_factura)
);

CREATE TABLE productos_primeraformanormal (
	id_factura int not null,
	IVA decimal(10,0) not null,
    cantidad int not null,
	descripción_artículo varchar(40) not null,
	FOREIGN KEY (id_factura) REFERENCES facturas_primeraformanormal(id_factura)
);

-- No esta en segunda forma normal porque en la tabla de clientes y de productos las columnas no dependen del
-- id_factura, dependen de un id que los identifique (llave artificial)
-- Además se tendrán que crear las correspondientes tablas para no perder las relaciones

CREATE TABLE facturas_segundaformanormal (
	id_factura int primary key,
    fecha_factura date not null,
    forma_pago varchar(20) not null,
    importe decimal(10,0) not null
);

CREATE TABLE clientes_segundaformanormal (
	id_cliente int primary key,
    nombre_cliente varchar(40) not null,
    apellido_cliente varchar(40) not null
);

CREATE TABLE productos_segundaformanormal (
	id_producto int primary key,
	IVA decimal(10,0) not null,
	descripción_artículo varchar(40) not null
);


CREATE TABLE cliente_factura_segundaformanormal (
	id_factura int not null,
    id_cliente int not null,
	PRIMARY KEY (id_factura, id_cliente),
	FOREIGN KEY (id_factura) REFERENCES facturas_segundaformanormal(id_factura),
	FOREIGN KEY (id_cliente) REFERENCES clientes_segundaformanormal(id_cliente)
);

CREATE TABLE producto_factura_segundaformanormal (
	id_factura int not null,
    id_producto int not null,
	cantidad int not null,
	PRIMARY KEY (id_factura, id_producto),
	FOREIGN KEY (id_factura) REFERENCES facturas_segundaformanormal(id_factura),
	FOREIGN KEY (id_producto) REFERENCES productos_segundaformanormal(id_producto)
);

-- Para llegar a tercera forma normal identificamos que la única columna que no depende de la llave primaria
-- es la forma de pago, para eso se introduce una nueva tabla con un identificador artificial y se relaciona 
-- con la factura, todo lo demás queda igual
CREATE TABLE formas_de_pago_terceraformanormal (
	id_forma_de_pago int primary key,
    nombre varchar(20) not null
);

CREATE TABLE facturas_terceraformanormal (
	id_factura int primary key,
    fecha_factura date not null,
    id_forma_de_pago int not null,
    importe decimal(10,0) not null,
	FOREIGN KEY (id_forma_de_pago) REFERENCES formas_de_pago_terceraformanormal(id_forma_de_pago)
);

CREATE TABLE clientes_terceraformanormal (
	id_cliente int primary key,
    nombre_cliente varchar(40) not null,
    apellido_cliente varchar(40) not null
);

CREATE TABLE productos_terceraformanormal (
	id_producto int primary key,
	IVA decimal(10,0) not null,
	descripción_artículo varchar(40) not null
);


CREATE TABLE cliente_factura_terceraformanormal (
	id_factura int not null,
    id_cliente int not null,
	PRIMARY KEY (id_factura, id_cliente),
	FOREIGN KEY (id_factura) REFERENCES facturas_terceraformanormal(id_factura),
	FOREIGN KEY (id_cliente) REFERENCES clientes_terceraformanormal(id_cliente)
);

CREATE TABLE producto_factura_terceraformanormal (
	id_factura int not null,
    id_producto int not null,
	cantidad int not null,
	PRIMARY KEY (id_factura, id_producto),
	FOREIGN KEY (id_factura) REFERENCES facturas_terceraformanormal(id_factura),
	FOREIGN KEY (id_producto) REFERENCES productos_terceraformanormal(id_producto)
);