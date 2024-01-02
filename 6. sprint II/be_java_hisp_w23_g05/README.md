# Sprint N° 2
### Grupo 5
## User Stories
SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:

### US-0001: 
Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

### US-0002: 
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

### US-0003: 
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
### US-0004: 
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
### US-0005: 
Dar de alta una nueva publicación.
### US-0006: 
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
### US-0007: 
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
### US-0008: 
Ordenamiento alfabético ascendente y descendente.
### US-0009: 
Ordenamiento por fecha ascendente y descendente.
​


## Tests Unitarios:
A continuación se solicita una serie de test unitarios a llevar a cabo; sin embargo, en caso de que se considere necesario implementar otros, esto es totalmente viable.


|  | Situaciones de entrada     | Comportamiento Esperado                |
| :-------- | :------- | :------------------------- |
| `T-0001 ` | Verificar que el usuario a seguir exista. `(US-0001)`    |**Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.|
| `T-0002 ` | Verificar que el usuario a dejar de seguir exista. `(US-0007)`    |**Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.|
| `T-0003 ` | Verificar que el tipo de ordenamiento alfabético exista `(US-0008)`    |**Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.|
| `T-0004 ` | Verificar el correcto ordenamiento ascendente y descendente por nombre. `(US-0008)`    |**Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.|
| `T-0005 ` | Verificar que el tipo de ordenamiento por fecha exista `(US-0009)`    |**Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.|
| `T-0006 ` | Verificar el correcto ordenamiento ascendente y descendente por fecha. `(US-0009)`    |Verificar el correcto ordenamiento ascendente y descendente por fecha. **(US-0009)**|
| `T-0007 ` | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. `(US-0002)`    |Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario. |
| `T-0008 ` | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. `(US-0006)`    |Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.|


​
## Tests y responsables de su programación
​
| || Responsable |
| :---         |     :---:      |          ---: |
| `T-0001`     || Nicolas Reinaldo, Fátima Noble, Tiago Ramirez     |
| `T-0002`   || Ailen Pereira Vilches, Brenda Torrico    |
| `T-0003`   || Nicolas Reinaldo, Fátima Noble, Tiago Ramirez|
| `T-0004`   || Gerónimo Schmidt, Lucas Salerno |
| `T-0005`   || Ailen Pereira Vilches, Brenda Torrico   |
| `T-0006`   || Gerónimo Schmidt, Lucas Salerno  |
| `T-0007`   || Nicolas Reinaldo, Fátima Noble, Tiago Ramirez |
| `T-0008`   || `ALL`|


## Integrantes

​
 - [@Tiago Ramirez](https://github.com/tiagoramirez-meli) 
​ 
- [@Lucas Salerno](https://github.com/lucassalerno)
​
- [@Gerónimo Schmidt](https://github.com/gschmidtt)
​
- [@Fátima Noble](https://github.com/fatimanobleg)
​
- [@Brenda Torrico](https://github.com/bntorricoc)
​
- [@Nicolas Reinaldo](https://github.com/NicolasReinaldo)
​
- [@Ailen Pereira Vilches](https://github.com/ailenvilches)
