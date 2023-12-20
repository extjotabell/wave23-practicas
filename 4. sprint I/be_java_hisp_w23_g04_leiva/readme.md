# Programación Java - Sprint 1

### Como se ejecuta la API

Para ejecutar y desarrollar esta API necesitas:

- **Java Development Kit (JDK):** version 17
- **Maven:** Herramienta de gestión y construcción de proyectos.

Estos son los pasos para ejecutar la API

1. Abrir el proyecto con tu IDE.
2. Localizar la clase principal llamada `BeJavaHispW23G04Application`
3. Ejecutar la aplicación directamente desde esa clase.


### Como probar la API

Para facilitat la prueba de los distintos endpoints de la API, proporcionamos una collección de Postman con pruebas predefenidas. Estas pruebas están organizadas y listas para ser utilizadas para validar la funcionalidad de la API.

#### Ubicación de la colección de Postman:

La colección de Postman de postman se encuentra en el directorio del proyecto bajo **`resources/SocialMeli.postman_collection.json`**

#### Estructura de la colección.

La colección está organizada por carpetas, cada una correspondiente a un endpoint diferente de la API. Facilitando la navegación y ejecución de pruebas especificas para cada funcionalidad.

#### Pasos para utilizar la colección de Postman: 

1. **Importar colección:** Se debe iniciar Postman y podes importar la colección seleccionando **`File > Import`** y luego buscando el archivo de collección en **`resources/SocialMeli.postman_collection.json`**
2. **Ejecutar pruebas:** Navega por las carpetas de la colección para encontrar las pruebas específicas para cada endpoint.


## Requerimientos incrementales 
SocialMeli tiene como objetivo extra lograr permitir a los vendedores la posibilidad de publicar nuevos productos con ofertas o descuentos especiales exclusivos para sus seguidores por un determinado período de tiempo. Para ello propone los siguientes requerimientos:
Llevar a cabo la publicación de un nuevo producto en promoción.
Obtener la cantidad de productos en promoción de un determinado vendedor
Estos requerimientos están pensados para ser llevados a cabo de manera individual por un especialista.
Tener en cuenta que, como son requerimientos incrementales al trabajo que se haya hecho en equipo, se debe respetar el desarrollo base que se haya logrado en éste.
Por otro lado, tener en cuenta para estos requerimientos la posibilidad de poder ordenarlos alfabéticamente por nombre de cada producto tanto de forma ascendente como descendente.

### US 0010:

Llevar a cabo la publicación de un nuevo producto en promoción

#### Endpoint

- **Método:** POST

- **Ejemplos:**

`/products/promo-post`

#### Formato de Body

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

#### Respuestas

- **Status Code 200:** Status Code 200 (todo OK)
- **Status Code 400:** Status Code 400 (Bad Request)

### US 0011:

Obtener la cantidad de productos en promoción de un determinado vendedor

#### Endpoint

- **Método:** GET

- **Ejemplos:**

`/products/promo-post/count?user_id={userId}`

#### Filtros y Parámetros

| order       | Descripción             |
|-------------|-------------------------|
| `user_id`   |  Número que identifica a cada usuario |


- **Formato de Respuesta:**

  ```json
  {  
     "user_id" : 234,
     "user_name": "vendedor1",
     "promo_products_count": 23
  }
  ```

## Requerimientos incrementales 
Para finalizar, desde Mercado Libre dieron a conocer que están abiertos a cualquier nueva funcionalidad o propuesta de mejora para “SocialMeli”. En caso de que esto se lleve a cabo, será necesario, además de desarrollar la funcionalidad, presentar la documentación técnica asociada.

### US 0012:

Obtener un listado de todos los vendedores que tienen en promoción un determinado producto.

#### Endpoint

- **Método:** GET
- **URL:** GET `/products/promo-post/sellers?product_name={productName}`
- **Ejemplos:** `/products/promo-post/sellers?product_name=silla gamer`

#### Filtros y Parámetros

| order       | Descripción             |
|-------------|-------------------------|
| `product_name`   |  Cadena de caracteres que representa el nombre de un producto |


- **Formato de Respuesta:**

  ```json
  {
    "sellers": [
        {
            "user_id": 1,
            "user_name": "Vendedor1",
            "product": {
                "date": "20-12-2023",
                "product": {
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition",
                    "product_id": 1,
                    "product_name": "Silla Gamer"
                },
                "category": 100,
                "price": 1500.5,
                "discount": 0.25,
                "user_id": 2,
                "has_promo": true
            }
        },
        {
            "user_id": 2,
            "user_name": "Vendedor2",
            "product": {
                "date": "20-12-2023",
                "product": {
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition",
                    "product_id": 1,
                    "product_name": "Silla Gamer"
                },
                "category": 100,
                "price": 1230.5,
                "discount": 0.30,
                "user_id": 2,
                "has_promo": true
            }
        }
    ]
  }
  ```

