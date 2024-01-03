
# SocialMeli Equipo 3 - Sprint 2 W23

## Descripcion del Problema

**SocialMeli**, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Definiciones de Equipo

Para ejecutar la API es necesario descargar los archivos de este repositorio y abrirlos con un IDE, de preferencia **IntelliJ IDEA**. Dentro del IDE basta con ejecutar el archivo **BeJavaHispW23G3Application** ubicado en **src/main/java/be_java_hisp_w23_g3**. La API corre por defecto en el **puerto 8080 de localhost.**

Para hacer pruebas se recomienda usar Postman. Todos los endpoints y casos de prueba del API están recogidos en esta colección: [SocialMeli W23 G3](https://socialmeli-w23-g3.postman.co/workspace/SocialMeli-W23-G3~6050674e-6fac-4fbb-9cb6-0866bafb900b/collection/31877782-e4b7f017-69b9-42d1-addb-186665b8eac1?action=share&source=collection_link&creator=31612332), que también puede encontrarse dentro de los archivos del repositorio como: **SocialMeli_W23_G3.postman_collection.json**

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

## Tests y Responsables
| Requerimiento        | Descripción                                                                                                                                                                                  | Comportamiento Esperado                                                                                                                            | Responsable                   |
|----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------|
| T-0001               | Verificar que el usuario a seguir exista. **(US-0001)**                                                                                                                                      | **Se cumple:**  Permite continuar con normalidad. <br /> **No se cumple:** Notifica la no existencia mediante una excepción.                       | Diana Isabel Ramírez García   |
| T-0002               | Verificar que el usuario a dejar de seguir exista. **(US-0007)**                                                                                                                             | **Se cumple:**  Permite continuar con normalidad. <br /> **No se cumple:** Notifica la no existencia mediante una excepción.                       | Diana Isabel Ramírez García   |
| T-0003               | Verificar que el tipo de ordenamiento alfabético exista **(US-0008)**                                                                                                                        | **Se cumple:**  Permite continuar con normalidad. <br /> **No se cumple:** Notifica la no existencia mediante una excepción.                       | Miguel Ochoa Mejía            |
| T-0004               | Verificar el correcto ordenamiento ascendente y descendente por nombre. **(US-0008)**                                                                                                        | Devuelve la lista ordenada según el criterio solicitado                                                                                            | Miguel Ochoa Mejía            |
| T-0005               | Verificar que el tipo de ordenamiento por fecha exista **(US-0009)**                                                                                                                         | **Se cumple:**  Permite continuar con normalidad. <br /> **No se cumple:** Notifica la no existencia mediante una excepción.                       | Sebastian Ospina García       |
| T-0006               | Verificar el correcto ordenamiento ascendente y descendente por fecha. **(US-0009)**                                                                                                         | Verificar el correcto ordenamiento ascendente y descendente por fecha. **(US-0009)**                                                               | Sebastian Ospina García       |
| T-0007               | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. **(US-0002)**                                                                                                | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                                                          | Jhon Edison García García     |
| T-0008               | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. **(US-0006)**                     | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | Jorge Rodrigo Marcos Martínez |
| Validaciones         | Añadir las validaciones necesarias a los DTOs                                                                                                                                                | **Se cumple:**  Permite continuar con normalidad. <br /> **No se cumple:** Notifica la no existencia mediante una excepción.                       | Emmanuel López Rodríguez      |
| Tests de Integración | Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración | Implementación de al menos un test de integración para lograr una cobertura de código mayor que la lograda con los tests unitarios                 | Diana Isabel Ramírez García   |



## Integrantes

- Diana Isabel Ramírez García
- Emmanuel López Rodríguez
- Jhon Edison García García
- Jorge Rodrigo Marcos Martínez
- Miguel Ochoa Mejía
- Sebastian Ospina García