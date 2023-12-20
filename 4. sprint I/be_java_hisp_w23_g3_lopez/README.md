
# SocialMeli Equipo 3 - Sprint 1 W23

## Descripcion del Problema

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como **SocialMeli**, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Definiciones de Equipo

Para ejecutar la API es necesario descargar los archivos de este repositorio y abrirlos con un IDE, de preferencia **IntelliJ IDEA**. Dentro del IDE basta con ejecutar el archivo **BeJavaHispW23G3Application** ubicado en **src/main/java/be_java_hisp_w23_g3**. La API corre por defecto en el **puerto 8080 de localhost.**

Para hacer pruebas se recomienda usar Postman. Todos los endpoints y casos de prueba del API están recogidos en esta colección: [SocialMeli W23 G3](https://socialmeli-w23-g3.postman.co/workspace/SocialMeli-W23-G3~6050674e-6fac-4fbb-9cb6-0866bafb900b/collection/31877782-e4b7f017-69b9-42d1-addb-186665b8eac1?action=share&source=collection_link&creator=31612332), que también puede encontrarse dentro de los archivos del repositorio como: **SocialMeli_W23_G3.postman_collection.json** Para el caso de los endpoints US0010, US0011, Bonus 1 y Bonus 2, los casos de prueba se ecuentran en el archivo **SocialMeli_W23_G3_Lopez.postman_collection.json**.

## Endpoints y responsables

| Requerimiento | Descripción                                                                                                           | Responsable                                        |
|---------------|-----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| US0001        | Poder realizar la acción de “Follow” (seguir) a un determinado vendedor                                               | Diana Isabel Ramírez García                        |
| US0002        | Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor                                  | Miguel Ochoa Mejía                                 |
| US0003        | Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)                      | Sebastian Ospina García                            |
| US0004        | Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)                | Jhon Edison García García                          |
| US0005        | Dar de alta una nueva publicación                                                                                     | Emmanuel López Rodríguez                           |
| US0006        | Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas | Jorge Rodrigo Marcos Martínez y Miguel Ochoa Mejía |
| US0007        | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.                                   | Diana Isabel Ramírez García                        |
| US0008        | Ordenamiento alfabético ascendente y descendente                                                                      | Miguel Ochoa Mejía                                 |
| US0009        | Ordenamiento por fecha ascendente y descendente                                                                       | Sebastian Ospina García                            |
| US0010        | Llevar a cabo la publicación de un nuevo producto en promoción                                                        | Emmanuel López Rodríguez                           |
| US0011        | Obtener la cantidad de productos en promoción de un determinado vendedor                                              | Emmanuel López Rodríguez                           |
| Bonus 1       | Conseguir un producto individual por su ID                                                                            | Emmanuel López Rodríguez                           |
| Bonus 2       | Crear un usuario nuevo                                                                                                | Emmanuel López Rodríguez                           |

## Documentación de los Endpoints bonus

### Bonus 1

Conseguir un producto individual por su ID: ```GET: /products/post/{postId}```

**Response:**

- **200 OK:**
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
- **404 Not Found:**
    ```json
    {
      "message": "Post not found"
    }
    ```

### Bonus 2

Crear un usuario nuevo: ```POST: /users/```.  En este caso el id del usuario se genera automáticamente.

**Request:**

```json
{
  "user_name": "Juan Perez"
}
```

**Response:**

- **201 Created:**
    ```json
    {
      "user_id": 234,
      "user_name": "Juan Perez"
    }
    ```
  
- **400 Bad Request:**
    ```json
    {
      "message": "User already exists"
    }
    ```

## Integrantes

- Diana Isabel Ramírez García
- Emmanuel López Rodríguez
- Jhon Edison García García
- Jorge Rodrigo Marcos Martínez
- Miguel Ochoa Mejía
- Sebastian Ospina García