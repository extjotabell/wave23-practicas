# SOCIAL MELI

Este proyecto reune 9 historias de usuario para el desarrollo inicial (Sprint - 1) del API de SocialMeli y sus respectivos test unitarios (Sprint - 2). Mercado Libre tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
“SocialMeli” es un aplicativo donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen (Sprint - 1). Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones y diferentes test unitarios que aseguren el correcto funcionamiento (Spring - 2).

## Sprint 1
## Instalación

1. Ubicarse en la dirección donde se encuentra alojado el proyecto o abrir el proyecto desde su IDE favorito.

2. Si esta desde la consola ejercutar:
```bash
mvn spring-boot:run. 
```
o "Run" desde el IDE.

3. Desde postman u otra herramienta importe la colección de requests de prueba. Este archivo se encuentra en :
   [Postman](https://github.com/zulyvargasrz/be_java_hisp_w23_g01/tree/main/src/test/postman)


4. Ejecutar una a una las request. Estas puede encontrarlas agrupadas por Historia de Usuario:

![postman.png](img%2Fpostman.png)

Ejecute primero el request LoadTestData para cargar datos de prueba.


## EndPoints:

URL base: http://localhost:8080

1. **[POST] US 0001:** Poder realizar la acción de “Follow” (seguir) a un determinado vendedor:

      ***Reponsable: Alfredo Tonatiuh***


    /users/{userId}/follow/{userIdToFollow}

   **Ejemplo:** /users/123/follow/234


2. **[GET] US 0002:** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor:

   ***Reponsable: Alfredo Tonatiuh***
 

    /users/{userId}/followers/count

   **Ejemplo:** /users/234/followers/count/


3. **[GET] US 0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?):

   ***Reponsable: Zuly Vargas***


    /users/{userId}/followers/list

   **Ejemplo:** /users/234/followers/list

   **US 0008:** Ordenamiento alfabético ascendente y descendente

   El ordenamiento se realiza ascendente por defecto.


    /users/{UserID}/followers/list?order=name_asc.     
    /users/{UserID}/followers/list?order=name_desc


4. **[GET] US 0004:** Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
   
    ***Reponsable: Zuly Vargas***


    /users/{userId}/followed/list

   **Ejemplo:** /users/4698/followed/list

   **US 0008:** Ordenamiento alfabético ascendente y descendente

   El ordenamiento se realiza ascendente por defecto.

   
    /users/{UserID}/followed/list?order=name_asc   
    /users/{UserID}/followed/list?order=name_desc


5. **[POST] US 0005:** Dar de alta una nueva publicación

   ***Reponsable: Danilo Quiroga***


    /products/post

   **Payload:**

 ```json
        {
        "user_id": 123,
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
        "price": 1500.50
        }
```


6. **[GET] US 006:** Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).


   ***Reponsable: Fernando Meza***


    /products/followed/{userId}/list

   **Ejemplo:** Ejemplo: /products/followed/4698/list    

   **US 0009:** Ordenamiento por fecha ascendente y descendente.      

    /products/followed/{userId}/list?order=date_asc.   
    /products/followed/{userId}/list?order=date_desc



7. **[POST] US 0007:** Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

    ***Reponsable: Andrés Limpio***

      /users/{userId}/unfollow/{userIdToUnfollow}

   **Ejemplo:** /users/234/unfollow/123


## Sprint 2

- Validaciones para datos de entrada:

| Datos/Parámetros  | Tipo     |     Longitud      | Descripción                                                                    |
|:------------------|:---------|:-----------------:|--------------------------------------------------------------------------------|
| user_id           | Integer  |                   | Número que identifica al usuario actual                                        |
| user_id_to_follow | Integer  |                   | Número que identifica al usuario a seguir                                      |
| use_name          | String |        15         | Nombre de usuario asociado a la user_id                                        |
| followers_count   | Integer |                   | Cantidad de seguidores                                                         |
| id_post           | Integer |                   | Número identificatorio de cada una de las publicaciones                        |
| date              | Date |                   | Fecha de la publicación en formato dd-MM-yyyy                                  |
| product_id        | Integer |                   | Número identificatorio de cada uno de los productos asociados a una publicación |
| product_name      | String |        40         | Cadena de caracteres que representa el nombre de un producto                   |
| type              | String |        15         | Cadena de caracteres que representa el tipo de un producto                     |
| brand             | String |        25         | Cadena de caracteres que representa la marca de un producto                    |
| color             | String |        15         | Cadena de caracteres que representa el color de un producto                    |
| notes             | String |        80         | Cadena de caracteres para colocar notas u observaciones de un producto      |
| category          | Integer |                   | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price             | Double  | 10.000.000 (Max)  | Precio del producto en dólares            |
| user_id_to_unfollow | Integer |                   | Número que identifica al usuario a dejar de seguir                 |
| order | String |                   | Establece el ordenamiento. Puede poseer los valores: name_asc, name_desc, date_asc, date_desc|


- Test unitarios realizados para cada historia de usuario:

  Para ejecutar los test desde la consola usar:
   ```bash
   mvn test 
   ```

| Test Unitario                                              | Situaciones de entrada                                                                                                                                                   | Comportamiento Esperado                                                                                                                            | Responsale |
|:-----------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------|-------------|
| T-0001                                                     | Verificar que el usuario a seguir exista. `(US-0001)`                                                                                                                    | **Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.                               |  Alfredo Tonatiuh |
| T-0002                                                     | Verificar que el usuario a dejar de seguir exista. `(US-0007)`                                                                                                           | **Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.                               | Andrés Limpio |
| T-0003                                                     | Verificar que el tipo de ordenamiento alfabético exista `(US-0008)`                                                                                                      | **Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.                               | Zuly Vargas |
| T-0004                                                     | Verificar el correcto ordenamiento ascendente y descendente por nombre. `(US-0008)`                                                                                      | **Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.                               | Zuly Vargas |
| T-0005                                                     | Verificar que el tipo de ordenamiento por fecha exista `(US-0009)`                                                                                                       | **Se cumple**: Permite continuar con normalidad. **No se cumple**: Notifica la no existencia mediante una excepción.                               | Fernando Meza |
| T-0006                                                     | Verificar el correcto ordenamiento ascendente y descendente por fecha. `(US-0009)`                                                                                       | Verificar el correcto ordenamiento ascendente y descendente por fecha. **(US-0009)**                                                               | Fernando Meza |
| T-0007                                                     | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. `(US-0002)`                                                                              | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                                                          | Alfredo Tonatiuh |
| T-0008                                                     | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. `(US-0006)`   | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | Fernando Meza |
| T-0009                                                     | Verificar la correcta creación de un nuevo Post `(US-0005)`                                                                                                              | Indica el id del usuario y la confirmación de la creación.                                                                                         | Danilo Quiroga |



## Pruebas de integración (Individual obligatorio)



**[POST] US 0001:** Poder realizar la acción de “Follow” (seguir) a un determinado vendedor:

    /users/{userId}/follow/{userIdToFollow}

**T-0010:** Usuario logra seguir al otro usuario con éxito



## Pruebas de integración (Individual extra)


**[POST] US 0001:** Poder realizar la acción de “Follow” (seguir) a un determinado vendedor:

    /users/{userId}/follow/{userIdToFollow}

**T-0011**: Usuario no logra seguir al otro usuario porque ya lo esta siguiendo.



## Integrantes:
- Andres Alejandro Limpio
- Alfredo Tonatiuh Diaz
- Fernando Meza Ortega
- Yadir Danilo Quiroga
- Zuly Valentina Vargas


