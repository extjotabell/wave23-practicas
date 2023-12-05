package com.ospina.cifradoCesar.controlador;

import com.ospina.cifradoCesar.modelo.MensajeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cesar")
public class ControladorCesar {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @PostMapping("/encriptar")
    public ResponseEntity<String> encriptar(@RequestBody MensajeRequest mensajeRequest) {
        try {
            String mensaje = mensajeRequest.getMensaje().toUpperCase().replaceAll("\\s", "");
            String clave23 = "23";
            String clave012 = "012";

            String mensajeEncriptadoClave23 = encriptarMensaje(mensaje, clave23);
            String mensajeEncriptadoClave012 = encriptarMensaje(mensaje, clave012);

            return ResponseEntity.ok("Mensaje encriptado (clave 23): " + mensajeEncriptadoClave23 + "\n" +
                    "Mensaje encriptado (clave 012): " + mensajeEncriptadoClave012);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al encriptar el mensaje: " + e.getMessage());
        }
    }

    private String encriptarMensaje(String mensaje, String clave) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        int indiceClave = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            int indiceLetra = ALPHABET.indexOf(mensaje.charAt(i));
            if (indiceLetra == -1) {
                throw new IllegalArgumentException("Caracter no permitido en el mensaje: " + mensaje.charAt(i));
            }
            int indiceClaveActual = Integer.parseInt(String.valueOf(clave.charAt(indiceClave)));
            int indiceLetraEncriptada = (indiceLetra + indiceClaveActual) % ALPHABET.length();
            mensajeEncriptado.append(ALPHABET.charAt(indiceLetraEncriptada));
            indiceClave = (indiceClave + 1) % clave.length();
        }
        return mensajeEncriptado.toString();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error: " + ex.getMessage());
    }
}
