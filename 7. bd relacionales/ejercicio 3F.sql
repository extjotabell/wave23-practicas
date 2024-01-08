/* 

Cliente:
id_cliente (PK)
nombre_cliente
apellido_cliente
direccion_cliente


Factura:
id_factura (PK)
id_cliente (FK referenciando id_cliente en la tabla Cliente)
fecha_factura
forma_pago
iva


DetalleFactura:
id_detalle (PK)
id_factura (FK referenciando id_factura en la tabla Factura)
cantidad
importe
descripcion_articulo

*/