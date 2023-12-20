
# Sprint N° 1

Presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.
​

## Definiciones de Equipo
​
En el archivo `SPRINT 1.postman_collection.json` se encuentra la colección de Postman para ejecutar las pruebas.


## API Reference


## Desarrollo Individual

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


## Requerimiento Bonus

#### US 0012: 
Buscar productos por categoría.
Como usuario interesado en productos, quiero buscar productos por categoría para encontrar artículos específicos de una categoría determinada.


```http
  GET /products/search?category_id={idCategory}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `categoryId ` | `int`    | Número que identifica a cada categoria|



​
## Endpoints y responsables de su programación
​
| Method | Endpoint | Responsable |
| :---         |     :---:      |          ---: |
| `POST`     | `US 0001` /users/{userId}/follow/{userIdToFollow}       | Nicolas Reinaldo     |
| `GET`   | `US 0002` /users/{userId}/followers/count     | Ailen Pereira Vilches    |
| `GET`   | `US 0003` /users/{userId}/followers/list     | Gerónimo Schmidt |
| `GET`   | `US 0004` /users/{userId}/followed/list     | Lucas Salerno    |
| `POST`   | `US 0005` /products/post     | `ALL`    |
| `GET`   | `US 0006` /products/followed/{userId}/list     | Tiago Ramirez    |
| `POST`   | `US 0007` /users/{userId}/unfollow/{userIdToUnfollow}     | Fátima Noble    |
| `GET`   | `US 0008` /users/{UserID}/followers/list?order=name_asc     | Ailen Pereira Vilches,  Nicolas Reinaldo  |
| `GET`   | `US 0009` /products/followed/{userId}/list?order=date_asc     | Brenda Torrico |

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
