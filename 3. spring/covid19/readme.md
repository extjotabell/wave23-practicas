Desarrollo de una API para realizar consultas respecto a la salud de una persona teniendo en cuenta determinados síntomas 
que pueda presentar. Para esto, existen dos clases: Persona, Sintoma.

La aplicación cuenta con la siguiente funcionalidad:

Ver todos los síntomas cargados.
PATH: /findSymptom

Consultar si existe un síntoma ingresando su nombre.
PATH: /findSymptom/{name}

Visualizar a las personas que puedan ser del grupo de riesgo (mayores de 60 años con sintomas).
PATH: /findRiskPerson
