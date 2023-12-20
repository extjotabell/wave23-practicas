# SOCIAL MELI

Este proyecto reune 9 historias de usuario para el desarrollo inicial (Sprint - 1) del API de SocialMeli. Mercado Libre tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
“SocialMeli” es un aplicativo donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.


## Instalación

1. Ubicarse en la dirección donde se encuentra alojado el proyecto o abrir el proyecto desde su IDE favorito.

2. Si esta desde la consola ejercutar:
```bash
mvn spring-boot:run. 
```
o "Run" desde el IDE.

3. Desde postman u otra herramienta importe la colección de requests de prueba. Este archivo se encuentra en :
   [Postman](src/test/postman/postman_collection.json)


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

   **Ejemplo:** /products/followed/4698/list    

   **US 0009:** Ordenamiento por fecha ascendente y descendente.      

    /products/followed/{userId}/list?order=date_asc.   
    /products/followed/{userId}/list?order=date_desc



7. **[POST] US 0007:** Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

    ***Reponsable: Andrés Limpio***

      /users/{userId}/unfollow/{userIdToUnfollow}

   **Ejemplo:** /users/234/unfollow/123



**Desarrollo Individual (Fernando Meza Ortega): **
10. **[POST] US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción


    /products/promo-post

**Payload:**

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



11. **[GET] US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor

    /products/promo-post/count?user_id={userId}

**Ejemplo:** /products/promo-post/count?user_id=1100



12. **[Delete] US 0011:** Borrar usuario por ID

    /users/{user_id}

**Ejemplo:** /users/1100



## Integrantes:
- Andres Alejandro Limpio
- Alfredo Tonatiuh Diaz
- Fernando Meza Ortega
- Yadir Danilo Quiroga
- Zuly Valentina Vargas