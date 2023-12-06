package com.ejemplo.encrypt.controllers;

import com.ejemplo.encrypt.entities.Mensaje;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cifrado")
public class CifradoController {
    List<String> abecedario = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    @PostMapping("/cifrar")
    public String cifrar(@RequestBody Mensaje mensaje) {
        Integer longitudClave = mensaje.getClave().length();
        String cifrado = null;
        if (longitudClave == 2) {
            cifrado = obtenerMensajeCifrado2(mensaje.getMensaje(), mensaje.getClave());
        } else if (longitudClave > 2) {
            cifrado = obtenerMensajeCifrado3(mensaje.getMensaje(), mensaje.getClave());
        }
        return cifrado;
    }

    @PostMapping("/decifrar")
    public String desifrar(@RequestBody Mensaje mensaje) {
        Integer longitudClave = mensaje.getClave().length();
        String decifrado = null;
        if (longitudClave == 2) {
            decifrado = obtenerMensajeDeCifrado2(mensaje.getMensaje(), mensaje.getClave());
        } else if (longitudClave > 2) {
            decifrado = obtenerMensajeDeCifrado3(mensaje.getMensaje(), mensaje.getClave());
        }
        return decifrado;
    }

    private String obtenerMensajeCifrado2(String mensaje, String clave) {
        StringBuilder resultado = new StringBuilder();
        Integer numeroPar = Integer.parseInt(String.valueOf(clave.toCharArray()[0]));
        Integer numeroImpar = Integer.parseInt(String.valueOf(clave.toCharArray()[1]));
        Integer indiceMensaje = 0;

        for (Character letra : mensaje.replace(" ", "").toCharArray()) {
            Integer indice = abecedario.indexOf(letra.toString());

            if (indiceMensaje % 2 == 0) {
                Integer indiceABuscar = indice + numeroPar;
                if (abecedario.size() <= indiceABuscar) {
                    indiceABuscar -= abecedario.size();
                    resultado.append(abecedario.get(indiceABuscar));
                } else {
                    resultado.append(abecedario.get(indiceABuscar));
                }
            } else {
                Integer indiceABuscar = indice + numeroImpar;
                if (abecedario.size() <= indiceABuscar) {
                    indiceABuscar -= abecedario.size();
                    resultado.append(abecedario.get(indiceABuscar));
                } else {
                    resultado.append(abecedario.get(indiceABuscar));
                }
            }
            indiceMensaje++;
        }
        return resultado.toString();
    }

    private String obtenerMensajeCifrado3(String mensaje, String clave) {
        StringBuilder resultado = new StringBuilder();
        Integer desplazamientoValue = 0;
        Integer indiceDesplazamiento = 0;

        for (Character letra : mensaje.replace(" ", "").toCharArray()) {
            if (indiceDesplazamiento >= clave.length()) {
                indiceDesplazamiento -= clave.length();
            }

            desplazamientoValue = Integer.parseInt(String.valueOf(clave.toCharArray()[indiceDesplazamiento]));
            Integer indice = abecedario.indexOf(letra.toString());

            Integer indiceABuscar = indice + desplazamientoValue;
            if (abecedario.size() <= indiceABuscar) {
                indiceABuscar -= abecedario.size();
                resultado.append(abecedario.get(indiceABuscar));
            } else {
                resultado.append(abecedario.get(indiceABuscar));
            }
            indiceDesplazamiento++;
        }
        return resultado.toString();
    }

    private String obtenerMensajeDeCifrado2(String mensaje, String clave) {
        StringBuilder resultado = new StringBuilder();
        Integer numeroPar = Integer.parseInt(String.valueOf(clave.toCharArray()[0]));
        Integer numeroImpar = Integer.parseInt(String.valueOf(clave.toCharArray()[1]));
        Integer indiceMensaje = 0;

        for (Character letra : mensaje.replace(" ", "").toCharArray()) {
            Integer indice = abecedario.indexOf(letra.toString());

            if (indiceMensaje % 2 == 0) {
                Integer indiceABuscar = indice - numeroPar;
                if (0 > indiceABuscar) {
                    indiceABuscar += abecedario.size();
                    resultado.append(abecedario.get(indiceABuscar));
                } else {
                    resultado.append(abecedario.get(indiceABuscar));
                }
            } else {
                Integer indiceABuscar = indice - numeroImpar;
                if (0 > indiceABuscar) {
                    indiceABuscar += abecedario.size();
                    resultado.append(abecedario.get(indiceABuscar));
                } else {
                    resultado.append(abecedario.get(indiceABuscar));
                }
            }
            indiceMensaje++;
        }
        return resultado.toString();
    }

    private String obtenerMensajeDeCifrado3(String mensaje, String clave) {
        StringBuilder resultado = new StringBuilder();
        Integer desplazamientoValue = 0;
        Integer indiceDesplazamiento = 0;

        for (Character letra : mensaje.replace(" ", "").toCharArray()) {
            if (indiceDesplazamiento >= clave.length()) {
                indiceDesplazamiento -= clave.length();
            }

            desplazamientoValue = Integer.parseInt(String.valueOf(clave.toCharArray()[indiceDesplazamiento]));
            Integer indice = abecedario.indexOf(letra.toString());

            Integer indiceABuscar = indice - desplazamientoValue;
            if (abecedario.size() <= indiceABuscar) {
                indiceABuscar += abecedario.size();
                resultado.append(abecedario.get(indiceABuscar));
            } else {
                resultado.append(abecedario.get(indiceABuscar));
            }
            indiceDesplazamiento++;
        }
        return resultado.toString();

    }
}
