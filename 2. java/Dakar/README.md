EJERCICIO DAKAR
Diagrama clases: https://github.com/extjotabell/wave23-practicas/assets/151570528/32a56099-f928-4dba-9795-8e9624dc8654

1. Crear la clase vehículo que tenga los siguientes atributos:
Velocidad
Aceleración
AnguloDeGiro
Patente
Peso
Ruedas



3. Modelar la clase Carrera que tiene los siguientes atributos:
Distancia
PremioEnDolares
Nombre
CantidadDeVehiculosPermitidos
Lista de Vehiculos

4. Se quiere agregar dos nuevas categorías de Vehiculos: 
Autos
Motos. 
Los autos pesan 1.000 kilos y las motos 300 kilos, los autos tienen 4 ruedas y las motos 2.

5. Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los siguientes métodos: 
public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
Ambos métodos agregan un vehículo siempre y cuando haya cupo.

6. También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
public void eliminarVehiculo(vehículo);
	public void eliminarVehiculoConPatente(String unaPatente);

7. Queremos poder definir el ganador de una carrera: 
El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)

8. Las carreras también cuentan con vehículos socorristas que ante alguna emergencia van y reparan a un vehículo. Como los autos son muy diferentes a las motos, existen dos clases distintas de vehículos socorristas. Uno de estos solo sabe socorrer autos y otro solo sabe socorrer motos.
Agregar las clases
	SocorristaAuto
	SocorristaMoto
Agregar los métodos:
		SocorristaAuto → public void socorrer(Auto unAuto)
	SocorristaMoto → public void socorrer(Moto unaMoto)

Cuando un socorrista se acerca a un auto imprime por pantalla “Socorriendo auto” y el número de patente, cuando socorre a una moto este imprime por pantalla “Socorriendo moto” y el número de patente.

Agregar a la clase carrera un socorrista de autos y uno de motos,.
Agregar a la carrera la responsabilidad de socorrer una moto y un auto:
	
public void socorrerAuto(String patente);
	public void socorrerMoto(String patente);
