
# “SocialMeli”


## Proyecto

Presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

Desarrollo extra a lo presentado en : [Proyecto Grupal](https://github.com/extjotabell/wave23-practicas/tree/pereira_ailen/4.%20sprint%20I/be_java_hisp_w23_g05)

## API Reference

#### US 0010: 
Llevar a cabo la publicación de un nuevo producto en promoción

```http
  POST /products/promo-post
```

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

```http
  GET /products/promo-post/count?user_id={userId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `user_name ` | `String`    | Cadena de caracteres que representa el nombre del usuario|
| `promo_products_count ` | `int`    | Cantidad numérica de productos en promoción de un determinado usuario.|

#### US 0012: 
Agregar publicaciones a una lista de favoritos.

```http
  POST //posts/{userId}/favorites/{postId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId ` | `int`    | Número que identifica a cada usuario|
| `postId ` | `int`    | Número que identifica a cada post|

#### US 0013: 
Obtener un listado de las publicaciones por filtros opcionales.

```http
  GET /posts?category={categoryId}&priceSince={priceSince}&priceTo={priceTo}&color={color}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `category ` | `Integer`    | Número que identifica a cada categoría|
| `priceSince ` | `Double`    | Número que identifica al precio inicial|
| `priceTo ` | `Double`    | Número que identifica al precio tope|
| `color ` | `String`    | Cadena de caracteres que representa el color de un producto|

## Ejecución de pruebas

En el archivo `SPRINT 1 -Individual.postman_collection.json` se encuentra la colección de Postman para ejecutar las pruebas correspondientes a los endpoints:

US 0010, US 0011

POST `/products/promo-post`

GET `/products/promo-post/count?user_id={userId}`

En el archivo `BONUS.postman_collection.json` se encuentra la colección de Postman para ejecutar las pruebas correspondientes a los endpoints:

US 0012, US 0013

POST `/posts/{userId}/favorites/{postId}`

GET `/posts?category={categoryId}&priceSince={priceSince}&priceTo={priceTo}&color={color}`

## Integrantes

Desarrollado con ♥ por  [Ailen Pereira Vilches](https://github.com/ailenvilches)