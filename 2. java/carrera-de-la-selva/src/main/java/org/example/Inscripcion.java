package org.example;

public class Inscripcion {

    private int id;
    private Participante participante;
    private Circuito circuito;
    private float valor;

    public Inscripcion(int id, Participante participante, Circuito circuito) {
        this.id = id;
        this.participante = participante;
        this.circuito = circuito;
        this.valor = calcularValorInscripcion();
    }

    private float calcularValorInscripcion() {
        String tipoCircuito = this.circuito.getTipo();

        if(tipoCircuito.equals(Circuito.CIRCUITO_CHICO)){
            if (this.participante.getEdad() < 18) {
                return 1300;
            }
            return 1500;
        }

        if(tipoCircuito.equals(Circuito.CIRCUITO_MEDIO)){
            if (this.participante.getEdad() < 18) {
                return 2000;
            }
            return 2300;
        }

        if(tipoCircuito.equals(Circuito.CIRCUITO_AVANZADO)){
            if (this.participante.getEdad() > 18) {
                return 2800;
            }
        }

        return -1;
    }

    public float getValor() {
        return this.valor;
    }

    public Participante getParticipante(){
        return this.participante;
    }

    public void mostrarDatos(){
        System.out.println("Nro. Inscripción: " + this.id);
        System.out.println("Tipo Circuito: " + this.circuito.getTipo());
        System.out.println("Participante: " + this.participante.getNombre() + ", " + this.participante.getApellido());
        System.out.println("Valor Inscripción: " + this.valor + "\n\n");
    }

    public String getTipoCircuito(){
        return this.circuito.getTipo();
    }
}
