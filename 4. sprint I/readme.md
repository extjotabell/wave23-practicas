# Programación Java. Sprint 1

## Descricpción del problema a resolver

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Definiciones de equipo

### Como se ejecuta la API

Para ejecutar y desarrollar esta API necesitas:

- **Java Development Kit (JDK):** version 17
- **Maven:** Herramienta de gestión y construcción de proyectos.

Estos son los pasos para ejecutar la API

1. Abrir el proyecto con tu IDE.
2. Localizar la clase principal llamada `BeJavaHispW23G04Application`
3. Ejecutar la aplicación directamente desde esa clase.


### Como probar la API

Para facilitar la prueba de los distintos endpoints de la API, proporcionamos una colección de Postman con pruebas predefenidas. Estas pruebas están organizadas y listas para ser utilizadas para validar la funcionalidad de la API.

#### Ubicación de la colección de Postman:

La colección de Postman se encuentra en el directorio del proyecto bajo **`resourses/SocialMeli.postman_collection.json`**

#### Estructura de la colección.

La colección está organizada por carpetas, cada una correspondiente a un endpoint diferente de la API. Facilitando la navegación y ejecución de pruebas especificas para cada funcionalidad.

#### Pasos para utilizar la colección de Postman: 

1. **Importar colección:** Se debe iniciar Postman y podes importar la colección seleccionando **`File > Import`** y luego buscando el archivo de collección en **`resourses/SocialMeli.postman_collection.json`**
2. **Ejecutar pruebas:** Navega por las carpetas de la colección para encontrar las pruebas específicas para cada endpoint.

## Endpoints y Responsables

### US 0001: Acción de "Follow" (Seguir) a un Vendedor

#### Endpoint

- **Método:** POST
- **URL:** `/users/{userId}/follow/{userIdToFollow}`
- **Ejemplo:** `/users/123/follow/234`

#### Respuestas

- **Status Code 200:** Operación exitosa. La respuesta puede ser sin cuerpo (bodyless) o con un Data Transfer Object (DTO).
- **Status Code 400:** Solicitud incorrecta (Bad Request). La respuesta puede ser sin cuerpo (bodyless) o con un DTO.

#### Filtros y Parámetros

| Parámetro      | Tipo | Descripción                             |
|----------------|------|-----------------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |
| `userIdToFollow`| int  | Número que identifica al usuario a seguir |

#### Responsable: 
Camila Mamani Llanquichoque

### US 0002: 

Obtener el Número de Seguidores de un Vendedor

#### Endpoint

- **Método:** GET
- **URL:** `/users/{userId}/followers/count`
- **Ejemplo:** `/users/234/followers/count`

#### Respuesta

- **Formato de Respuesta:**

  ```json
  {
      "user_id": 234,
      "user_name": "vendedor1",
      "followers_count": 35
  }
  ```

#### Filtros y Parámetros

| Parámetro      | Tipo | Descripción                             |
|----------------|------|-----------------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |

#### Responsable: 
Matias Nicolas Fiermarin

### US 0003: 

Obtener un Listado de Todos los Usuarios que Siguen a un Determinado Vendedor (¿Quién me sigue?)

#### Endpoint

- **Método:** GET
- **URL:** `/users/{userId}/followers/list`
- **Ejemplo:** `/users/234/followers/list`

#### Respuesta

- **Formato de Respuesta:**

  ```json
  {
    "user_id": 234,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
  }
  ```

#### Filtros y Parámetros

| Parámetro      | Tipo | Descripción                             |
|----------------|------|-----------------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |

#### Responsable: 
Tomas Eliseo Vazquez Moreyra

### US 0004: 

Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

#### Endpoint

- **Método:** GET
- **URL:** `/users/{userId}/followed/list`
- **Ejemplo:** `/users/4698/followed/list`

#### Respuesta

- **Formato de Respuesta:**

    ```json
  {
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
  }
  ```
#### Filtros y Parámetros

| Parámetro      | Tipo | Descripción                             |
|----------------|------|-----------------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |

#### Responsable: 
Federico Tagliabue

US 0005: 

Dar de alta una nueva publicación

#### Endpoint

- **Método:** POST
- **URL:** `/products/post`

#### Respuestas

- **Status Code 200:** Status Code 200 (todo OK)
- **Status Code 400:** Status Code 400 (Bad Request)

- **Payload:**

    ```json
  {
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
  }
  ```

#### Filtros y Parámetros

| Parámetro     | Tipo      | Descripción                                                  |
|---------------|-----------|--------------------------------------------------------------|
| `user_id`     | int       | Número que identifica a cada usuario                         |
| `date`        | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                |
| `product_id`  | int       | Número identificatorio de un producto asociado a una publicación |
| `product_name`| String    | Cadena de caracteres que representa el nombre de un producto |
| `type`        | String    | Cadena de caracteres que representa el tipo de un producto   |
| `brand`       | String    | Cadena de caracteres que representa la marca de un producto  |
| `color`       | String    | Cadena de caracteres que representa el color de un producto  |
| `notes`       | String    | Cadena de caracteres para colocar notas u observaciones de un producto |
| `category`    | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price`       | double    | Precio del producto                                          |

#### Responsable: 
Florencia Denise Leiva

### US 0006: 

Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

#### Endpoint

- **Método:** GET
- **URL:** `/products/followed/{userId}/list`
- **Ejemplo:** `/products/followed/4698/list`

#### Respuesta

- **Formato de Respuesta:**

  ```json
  {
    "user_id": 4698,
    "posts": [ {
            "user_id": 123, 
            "post_id": 32,
            "date": "01-05-2021",
            "product": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            "user_id": 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
    ]
  }
  ```

#### Filtros y Parámetros

| Parámetro      | Tipo | Descripción                             |
|----------------|------|-----------------------------------------|
| `userId`       | int  | Número que identifica al usuario actual |

#### Responsable: 
Cinthya Alexandra Fernandez

### US 0007: 

Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

#### Endpoint

- **Método:** POST
- **URL:** `/users/{userId}/unfollow/{userIdToUnfollow}`
- **Ejemplo:** `/users/234/unfollow/123`

#### Filtros y Parámetros

| Parámetro     | Tipo      | Descripción                                                  |
|---------------|-----------|--------------------------------------------------------------|
| `userId`           | int  | Número que identifica al usuario actual                      |
| `userIdToUnfollow` | int  | Número que identifica al usuario a dejar de seguir           |

#### Responsable: 
Gabriel Jesus Gutierrez Semidey

### US 0008: 

Ordenamiento alfabético ascendente y descendente
##### **Nota:** Este ordenamiento aplica solo para US-003 y US-004.

#### Endpoint

- **Método:** GET
- **Ejemplos:** 
1. `/users/{UserID}/followers/list?order=name_asc`
2. `/users/{UserID}/followers/list?order=name_desc`
3. `/users/{UserID}/followed/list?order=name_asc`
4. `/users/{UserID}/followed/list?order=name_desc`


#### Filtros y Parámetros

| order      | Descripción             |
|------------|-------------------------|
| `name_asc` | Alfabético ascendente   |
| `name_desc`| Alfabético descendente  |

#### Responsable: 
Federico Tagliabue y Tomas Eliseo Vazquez Moreyra

### US 0009: 

Ordenamiento por fecha ascendente y descendente
##### **Nota:** Este ordenamiento aplica solo para US-006.

#### Endpoint

- **Método:** GET
- **Ejemplos:** 
1. `/products/followed/{userId}/list?order=date_asc`
2. `/products/followed/{userId}/list?order=date_desc`


#### Filtros y Parámetros

| order      | Descripción             |
|------------|-------------------------|
| `date_asc` | Fecha ascendente (de más antigua a más nueva)   |
| `date_desc`| Fecha descendente (de más nueva a más antigua)  |

#### Responsable: 
Cinthya Alexandra Fernandez

### US 0010 (INDIVIDUAL): 

Llevar a cabo la publicación de un nuevo producto en promoción

#### Endpoint

- **Método:** POST
- **URL:** `/products/promo-post`

#### Respuestas

- **Status Code 200:** Status Code 200 (todo OK)
- **Status Code 400:** Status Code 400 (Bad Request)

- **Payload:**

    ```json
  {
    "user_id": 234,
    "date": "29-04-2021",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
    }
  ```

#### Filtros y Parámetros

| Parámetro     | Tipo      | Descripción                                                  |
|---------------|-----------|--------------------------------------------------------------|
| `user_id`     | int       | Número que identifica a cada usuario                         |
| `date`        | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                |
| `product_id`  | int       | Número identificatorio de un producto asociado a una publicación |
| `product_name`| String    | Cadena de caracteres que representa el nombre de un producto |
| `type`        | String    | Cadena de caracteres que representa el tipo de un producto   |
| `brand`       | String    | Cadena de caracteres que representa la marca de un producto  |
| `color`       | String    | Cadena de caracteres que representa el color de un producto  |
| `notes`       | String    | Cadena de caracteres para colocar notas u observaciones de un producto |
| `category`    | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price`       | double    | Precio del producto |
| `has_promo`    | boolean       | Campo true o false para determinar si un producto está en promoción o no |
| `discount`       | double    | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

#### Responsable: 
Federico Tagliabue

### US 0011 (INDIVIDUAL): 

Obtener la cantidad de productos en promoción de un determinado vendedor.

#### Endpoint

- **Método:** GET
- **URL:** `/products/promo-post/count?user_id={userId}`
- **Ejemplo:** `/users/234/unfollow/123`

- **Formato de Respuesta:**

  ```json
  {  
   "user_id" : 234,
   "user_name": "vendedor1",
   "promo_products_count": 23
  }
  ```

#### Filtros y Parámetros

| Parámetro     | Tipo      | Descripción                                                  |
|---------------|-----------|--------------------------------------------------------------|
| `userId`           | int  | Número que identifica al usuario actual                      |
| `user_name` | int  | Cadena de caracteres que representa el nombre del usuario           |
| `promo_products_count` | int  | Cantidad numérica de productos en promoción de un determinado usuario.|

### US 0013 (BONUS): 

Obtener un listado de las publicaciones realizadas por un usuario vendedor filtrado por categoría.

#### Endpoint

- **Método:** GET
- **URL:** `/products/post/user/{userId}?category={category}`
- **Ejemplo:** `/products/post/user/3?category=58`

- **Formato de Respuesta:**

  ```json
  [
    {
        "date": "19-12-2023",
        "product": {
            "type": "Gamer",
            "brand": "Redragon",
            "color": "Black",
            "notes": "Special Edition",
            "product_id": 2,
            "product_name": "Teclado"
        },
        "category": 58,
        "price": 800.0,
        "user_id": 3,
        "post_id": 1
    },
    {
        "date": "19-12-2023",
        "product": {
            "type": "Gamer",
            "brand": "Redragon",
            "color": "Black",
            "notes": "Special Edition",
            "product_id": 2,
            "product_name": "Teclado"
        },
        "category": 58,
        "price": 800.0,
        "user_id": 3,
        "post_id": 2
    }
  ]
  ```

#### Filtros y Parámetros

| Parámetro     | Tipo      | Descripción                                                  |
|---------------|-----------|--------------------------------------------------------------|
| `userId`           | int  | Número que identifica a cada usuario. (es obligatorio)       |
| `category` | int  | Número que identifica a cada categoría. (es obligatorio)             |

#### Responsable: 
Federico Tagliabue

## Integrantes
- Camila Mamani Llanquichoque
- Matias Nicolas Fiermarin
- Tomas Eliseo Vazquez Moreyra
- Federico Tagliabue
- Florencia Denise Leiva
- Cinthya Alexandra Fernandez
- Gabriel Jesus Gutierrez Semidey