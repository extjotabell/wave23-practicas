
# Social Meli

Presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Sprint 1


## Definiciones de equipo

En el archivo `SPRINT 1.postman_collection.json` se encuentra la colección de Postman para ejecutar las pruebas del proyecto grupal.
​
En el archivo `bootcamp Sprint 1.postman_collection.json` se encuentra la colección de Postman para ejecutar las pruebas del proyecto individual.
## API reference
## Desarrollo grupal

Grupo 5
#### US 0001:

Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
​
​
```http
  POST /users/{userId}/follow/{userIdToFollow}
```
​
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId ` | `int`    | Número que identifica al usuario actual|
| `userIdToFollow ` | `int`    | Número que identifica al usuario a seguir|



#### US 0002: 

Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
​
```http
  GET /users/{userId}/followers/count
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|


#### US 0003:

btener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
​
```http
  GET /users/{userId}/followers/list
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|

#### US 0004:

Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
​
```http
  GET /users/{userId}/followed/list
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|

#### US 0005:

ar de alta una nueva publicación
​
```http
  POST /products/post
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `date ` | `LocalDate`    | Fecha de la publicación en formato dd-MM-yyyy|
| `product_id ` | `int`    | Número identificatorio de un producto asociado a una publicación|
| `product_name ` | `String`    | Cadena de caracteres que representa el nombre de un producto|
| `type ` | `String`    | Cadena de caracteres que representa el tipo de un producto|
| `brand ` | `String`    | Cadena de caracteres que representa la marca de un producto|
| `color ` | `String`    |Cadena de caracteres que representa el color de un producto|
| `notes ` | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto|
| `category ` | `int`    | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados|
| `price ` | `double`    | Precio del producto|

#### US 0006:

Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
​
```http
  GET /products/followed/{userId}/list
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|

#### US 0007:

Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
​
```http
  GET /users/{userId}/unfollow/{userIdToUnfollow}
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `userIdToUnfollow ` | `int`    | Número que identifica al usuario a dejar de seguir|

#### US 0008:

Ordenamiento alfabético ascendente y descendente
​
```http
  Nota: Este ordenamiento aplica solo para US-003 y US-004.
```
​
| Parameter | Description                       |
| :-------- |  :-------------------------------- |
| `name_asc ` | Alfabético ascendente.|
| `name_desc ` | Alfabético descendente.|

#### US 0009:

Ordenamiento por fecha ascendente y descendente
​
```http
  Nota: Este ordenamiento aplica solo para la US-006
```
​
| Parameter | Description                       |
| :-------- |  :-------------------------------- |
| `date_asc ` | Fecha ascendente (de más antigua a más nueva)|
| `date_desc ` | Fecha descendente (de más nueva a más antigua)|


## Desarrollo individual
#### US 0010:

Llevar a cabo la publicación de un nuevo producto en promoción
​
```http
  POST /products/promo-post
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `date ` | `LocalDate`    | Fecha de la publicación en formato dd-MM-yyyy|
| `product_id ` | `int`    | Número identificatorio de un producto asociado a una publicación|
| `product_name ` | `String`    | Cadena de caracteres que representa el nombre de un producto|
| `type ` | `String`    | Cadena de caracteres que representa el tipo de un producto|
| `brand ` | `String`    | Cadena de caracteres que representa la marca de un producto|
| `color ` | `String`    |Cadena de caracteres que representa el color de un producto|
| `notes ` | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto|
| `category ` | `int`    | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados|
| `price ` | `double`    | Precio del producto|
| `has_promo ` | `boolean`    | Campo true o false para determinar si un producto está en promoción o no|
| `discount ` | `double`    | En caso de que un producto estuviese en promoción ,establece el monto de descuento.|


#### US 0011:

Obtener la cantidad de productos en promoción de un determinado vendedor
​
```http
  GET /products/promo-post/count?user_id={userId}
```
​
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `user_name ` | `String`    | Cadena de caracteres que representa el nombre del usuario|
| `promo_products_count ` | `int`    | Cantidad numérica de productos en promoción de un determinado usuario.|


#### US 0012:

Obtener un listado de todos los productos en promoción de un determinado vendedor

```http
  GET /products/promo-post/list?user_id={userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `user_name ` | `String`    | Cadena de caracteres que representa el nombre del usuario|
| `post_id ` | `int`    | Número identificatorio de cada una de las publicaciones|
| `date ` | `LocalTime`    | Fecha de la publicación en formato dd-MM-yyyy|
 `product_id ` | `int`    | Número identificatorio de un producto asociado a una publicación |
| `product_name ` | `String`    | Cadena de caracteres que representa el nombre de un producto|
| `type ` | `String`    | Cadena de caracteres que representa el tipo de un producto|
| `brand ` | `String`    | Cadena de caracteres que representa la marca de un producto|
| `color ` | `String`    |Cadena de caracteres que representa el color de un producto|
| `notes ` | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto|
| `category ` | `int`    | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados|
| `price ` | `double`    | Precio del producto|
| `has_promo ` | `boolean`    | Campo true o false para determinar si un producto está en promoción o no|
| `discount ` | `double`    | En caso de que un producto estuviese en promoción ,establece el monto de descuento.|

#### US 0013:

Obtener información sobre el tipo de vendedor que sigue un usuario y el total de vendedores seguidos

```http
  GET /users/type-of-sellers/{userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `userName ` | `String`    | Cadena de caracteres que representa el nombre del usuario|
| `sellersFollowed ` | `int`    | Cantidad numérica de vendedores que sigue el usuario.|
| `sellersWithPromo ` | `int`    | Cantidad numérica de vendedores que sigue el usuario y ofrecen promos.|
| `sellersWithoutPromo ` | `int`    | Cantidad numérica de vendedores que sigue el usuario y no ofrecen promos.|
| `description ` | `String`    | Breve conclusión sobre la cantidad de vendedores que sigue el usuario.|