
US0012 - Obtener listado de productos por rango de precios de un determinado vendedor.

Method      SIGN 
Get         /products?since=&to=&user_id=

Response:
{
    "user_name": "vendedor1",
    "posts": [
        {
            “user_id”: 234
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 11.50
        }
    ]
}

-----------------------------------------------------------------------------------------------------------------------|
|   Parámetros         |             Tipo          |            Descripción/Ejemplo                                    |
-----------------------------------------------------------------------------------------------------------------------|
|   user_id            |             int           |           Número que identifica a cada usuario                    |
-----------------------------------------------------------------------------------------------------------------------|
|   since              |             Double        |           Número que establece el rango menor del precio a buscar.|
-----------------------------------------------------------------------------------------------------------------------|
|   to                 |             Double        |           Número que establece el rango mayor del precio a buscar.|
-----------------------------------------------------------------------------------------------------------------------|

