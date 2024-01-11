# Joyería “Las Perlas”
    Práctica integradora
## Objetivo
El objetivo principal de esta práctica es afianzar los conocimientos vistos e implementar un servicio con operaciones CRUD. 

## Consigna
Una reconocida joyería desea implementar una API que permita las altas, bajas, modificaciones y lecturas
consultas de cada una de las joyas que tienen en exposición. Para ello, de cada joya se registran los siguientes datos: nro_identificatorio, nombre, material (oro, plata, etc), peso (en gramos), particularidad, posee_piedra, ventaONo.
A partir de esto, se necesita desarrollar una API que permita realizar un CRUD de cada joya. 

Para ello tener en cuenta que la API debe ser capaz de:


1. Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su “nro 
   identificatorio”. (URI: /jewerly/new).

2. Devolver el listado de todas las joyas registradas. (URI: /jewerly).

3. Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que se llama “ventaONo”, el 
   cual debe ser verdadero al crear una nueva joya, y falso cuando se solicite el eliminado. En caso de estar eliminado lógicamente, no deberá ser devuelto en el listado de joyas registradas. (URI: /jewerly/
   delete/{id})

4. Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje con el correspondiente 
   status code y los datos de la joya modificada. (URI: /jewerly/update/{id_modificar}). Envía el objeto 
   completo para editar (sin cambiar la id).

## Ejemplos para Postman
### 1. Nueva Joya

![Ejemplos para Postman.png](https://github.com/extjotabell/wave23-practicas/blob/limpio_andres/9.%20%20implementacion%20de%20bases%20de%20datos/jewerly/img/Ejemplos%20para%20Postman.png)

//nos fijamos con qué id se guarda este anillo para luego modificar con esa id en el punto 4

### 4. Joya Modificada
//para buscar la joya vamos a tomar la id con la que fue guardada en la bd mediante la generación automática.
//Vamos a modificar, por ejemplo la particularidad de la joya que guardamos en el punto 1
![Joya Modificada.png](https://github.com/extjotabell/wave23-practicas/blob/limpio_andres/9.%20%20implementacion%20de%20bases%20de%20datos/jewerly/img/Joya%20Modificada.png)

<p style="color:red;">
//Tener en cuenta que si usamos H2 como BD para los ejercicios (por defecto), cada vez que detengamos y volvamos a ejecutar la app, la BD se vacía y deberemos cargar de nuevo todos los registros
</p>