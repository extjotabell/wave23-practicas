Se desarrolla API con las siguientes funcionalidades:

1-Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.

2-Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.

3-Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
