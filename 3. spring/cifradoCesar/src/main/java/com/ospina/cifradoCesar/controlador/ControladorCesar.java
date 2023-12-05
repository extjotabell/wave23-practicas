package com.ospina.cifradoCesar.controlador;

import com.ospina.cifradoCesar.modelo.MensajeRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cesar")

public class ControladorCesar {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @GetMapping("/encriptar")
    public String encriptar(@RequestBody MensajeRequest mensajeRequest) {
        String mensaje = mensajeRequest.getMensaje().toUpperCase().replaceAll("\\s", "");
        String clave23 = "23";
        String clave012 = "012";

        String mensajeEncriptadoClave23 = encriptarMensaje(mensaje, clave23);
        String mensajeEncriptadoClave012 = encriptarMensaje(mensaje, clave012);

        return "Mensaje encriptado (clave 23): " + mensajeEncriptadoClave23 + "\n" +
                "Mensaje encriptado (clave 012): " + mensajeEncriptadoClave012;
    }

    private String encriptarMensaje(String mensaje, String clave) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        int indiceClave = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            int indiceLetra = ALPHABET.indexOf(mensaje.charAt(i));
            int indiceClaveActual = Integer.parseInt(String.valueOf(clave.charAt(indiceClave)));
            int indiceLetraEncriptada = (indiceLetra + indiceClaveActual) % ALPHABET.length();
            mensajeEncriptado.append(ALPHABET.charAt(indiceLetraEncriptada));
            indiceClave = (indiceClave + 1) % clave.length();
        }
        return mensajeEncriptado.toString();
    }

}
