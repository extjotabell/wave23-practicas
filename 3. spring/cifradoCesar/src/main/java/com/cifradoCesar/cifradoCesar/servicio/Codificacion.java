package com.cifradoCesar.cifradoCesar.servicio;
import org.springframework.stereotype.Service;

@Service
public class Codificacion {
    private final String clave23 = "23";
    private final String clave012 = "012";
    private static final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String codificacionConClave23(String mensaje) {
        return codificacionMensaje(mensaje, clave23);
    }

    public String codificacionConClave012(String mensaje) {
        return codificacionMensaje(mensaje, clave012);
    }

    public String codificacionMensaje(String mensaje, String clave) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        int indiceClave = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            int indiceLetra = alfabeto.indexOf(mensaje.charAt(i));
            int indiceClaveActual = Integer.parseInt(String.valueOf(clave.charAt(indiceClave)));
            int indiceLetraEncriptada = (indiceLetra + indiceClaveActual) % alfabeto.length();
            mensajeEncriptado.append(alfabeto.charAt(indiceLetraEncriptada));
            indiceClave = (indiceClave + 1) % clave.length();
        }
        return mensajeEncriptado.toString();
    }
}
