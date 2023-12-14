# Arquitectura Multicapa

## Estructura de carpetas
![carpetas](/docs/estructura_carpetas.png "Estructura de carpetas")

## Controller

Se encarga de manejar las request y response junto con los datos que contienen(comunicación con el cliente), 
además tiene control sobre los endpoints, y necesita comunicarse con el **Service** 
para seguir con el funcionamiento de la API.

* Se usa la anotación **@RestController**
* Solo debería conocer Objetos **DTOs**

## Service

Tiene que tener la mayor cantidad de lógica de negocio(cálculos, excepciones, etc), es la parte central de la API, 
recibe los datos del **Controller** para trabajar y según sea necesario puede comunicarse con el **Repository**.

* Se usa la anotación **@Service**
* Puede llegar a conocer todos los objetos **Models**, **DTOs** y **Entities**.
* Debido a que trabaja con distintos objetos
  - Suele tener alguna forma de *convertir un objeto en otro* 
  - Puede usar un *objeto para crear otro*
  - También se puede usar alguna librería como [Model Mapper](http://modelmapper.org/getting-started/)

## Repository

Su objetivo es controlar y persistir los **datos** de la API, se encarga de las operaciones de CRUD 
(Create, Read, Update, Delete) además puede llegar a devolver los datos *ordenados* y/o *filtrados* 
según sea necesario.

* Se usa la anotación **@Repository**
* Solo debería conocer Objetos **Entities**
* Pueden usar Objetos **Optional< T >**, donde T sería la entidad, pueden consultar este [blog de Baeldung](https://www.baeldung.com/java-optional)
* Disclaimer: vamos a trabajarlo como un listado de objetos en esta primera parte
* En un futuro usaremos algún ORM

# Tarea: completar las siguientes secciones

## DTO

## Entity

# Java Bean Validation Basics

* @NotNull validates that the annotated property value isn’t null.
* @AssertTrue validates that the annotated property value is true.
* @Size validates that the annotated property value has a size between the attributes min and max. We can apply it to String, Collection, Map, and array properties.
* @Min validates that the annotated property has a value no smaller than the value attribute.
* @Max validates that the annotated property has a value no larger than the value attribute.
* @Email validates that the annotated property is a valid email address.
* Some annotations accept additional attributes, but the message attribute is common to all of them. This is the message that will usually be rendered when the value of the respective property fails validation.

Here are some additional annotations we can find in the JSR:

* @NotEmpty validates that the property isn’t null or empty. We can apply it to String, Collection, Map or Array values.
* @NotBlank can be applied only to text values, and validates that the property isn’t null or whitespace.
* @Positive and @PositiveOrZero apply to numeric values, and validate that they’re strictly positive, or positive including 0.
* @Negative and @NegativeOrZero apply to numeric values, and validate that they’re strictly negative, or negative including 0.
* @Past and @PastOrPresent validate that a date value is in the past, or the past including the present. We can apply it to date types, including those added in Java 8.
* @Future and @FutureOrPresent validate that a date value is in the future, or in the future including the present.

We can also apply the validation annotations to elements of a collection:

* List<@NotBlank String> preferences;
