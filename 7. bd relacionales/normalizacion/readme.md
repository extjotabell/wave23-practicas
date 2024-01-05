## Normalización
### 1FN
Cada uno de los campos cumple con el principio de atomicidad por lo tanto 
se cumple la 1FN.

### 2FN
Sea desea eliminar toda dependencia funcional parcial. Una dependencia parcial
es aquella que no depende de la llave primaria para identificarlos.
Dicho lo anterior la llave primaria **id_factura** únicamente identifica a los campos
relacionados con una factura.
Por el otro lado en la tabla se cuentan con datos del cliente y de los articulos comprados.
Por lo tanto es posible crear dos nuevas tablas para alcanzar la 2FN.

### 3FN
Para la 3FN se desea eliminar toda dependencia transitiva, no obstante la relación
no cuenta con ellas , por lo tanto ya se encuentra en 3FN.
Cabe señalar que la relación entre articulo y factura es de muchos a muchos 
por lo tanto se traduce a una nueva tabla intermediaria. 


